package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Atendente;

public class AtendenteDAO {

    protected static Connection connection;
    protected static PreparedStatement prepareStatement;
    protected static ResultSet resultSet;
    
    public static List<Atendente> leTodos() throws Exception {
        List<Atendente> listaAtendente = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM atendente";
            connection = GerenteDeConexao.getConnection();
            prepareStatement = connection.prepareStatement(sql);
            resultSet = prepareStatement.executeQuery();
            
            while (resultSet.next()) {
                Atendente atendente = new Atendente();
                
                atendente.setMatricula(resultSet.getInt("matricula"));
                atendente.setNome(resultSet.getString("nome"));
                atendente.setFormacao(resultSet.getString("formacao"));
                atendente.setEndereco(EnderecoDAO.leUm(
                        resultSet.getInt("endereco_id")));
                
                listaAtendente.add(atendente);
            }
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return listaAtendente;
    }
    
    // like
    public static List<Atendente> leTodos(char letra) throws Exception {
        List<Atendente> listaAtendente = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM atendente WHERE nome LIKE ?";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, letra + "%");
            
            resultSet = prepareStatement.executeQuery();
            
            while (resultSet.next()) {
                Atendente atendente = new Atendente();
            
                atendente.setMatricula(resultSet.getInt("matricula"));
                atendente.setNome(resultSet.getString("nome"));
                atendente.setFormacao(resultSet.getString("formacao"));
                atendente.setEndereco(EnderecoDAO.leUm(
                        resultSet.getInt("endereco_id")));
                
                listaAtendente.add(atendente);
            }
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return listaAtendente;
    }
    
    // in
    public static List<Atendente> leTodos(int menorMatricula,
                                          int maiorMatricula) throws Exception {
        List<Atendente> listaAtendente = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM atendente WHERE matricula IN(?, ?)";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, menorMatricula);
            prepareStatement.setInt(2, maiorMatricula);
            
            resultSet = prepareStatement.executeQuery();
            
            while (resultSet.next()) {
                Atendente atendente = new Atendente();
            
                atendente.setMatricula(resultSet.getInt("matricula"));
                atendente.setNome(resultSet.getString("nome"));
                atendente.setFormacao(resultSet.getString("formacao"));
                atendente.setEndereco(EnderecoDAO.leUm(
                        resultSet.getInt("endereco_id")));
                
                listaAtendente.add(atendente);
            }
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return listaAtendente;
    }
    
    // not between
    public static List<Atendente> leTodos(short menorMatricula,
                                          int maiorMatricula) throws Exception {
        List<Atendente> listaAtendente = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM atendente"
                    + " WHERE nome NOT BETWEEN ? AND ?";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, menorMatricula);
            prepareStatement.setInt(2, maiorMatricula);
            
            resultSet = prepareStatement.executeQuery();
            
            while (resultSet.next()) {
                Atendente atendente = new Atendente();
            
                atendente.setMatricula(resultSet.getInt("matricula"));
                atendente.setNome(resultSet.getString("nome"));
                atendente.setFormacao(resultSet.getString("formacao"));
                atendente.setEndereco(EnderecoDAO.leUm(
                        resultSet.getInt("endereco_id")));
                
                listaAtendente.add(atendente);
            }
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return listaAtendente;
    }
    
    public static Atendente leUm(int matricula) throws Exception {
        Atendente atendente = new Atendente();
        
        try {
            String sql = "SELECT * FROM atendente WHERE matricula = ?";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, matricula);
            
            resultSet = prepareStatement.executeQuery();
            
            if (resultSet.next()) {
                atendente.setMatricula(resultSet.getInt("matricula"));
                atendente.setNome(resultSet.getString("nome"));
                atendente.setFormacao(resultSet.getString("formacao"));
                atendente.setEndereco(EnderecoDAO.leUm(
                        resultSet.getInt("endereco_id")));
            }
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return atendente;
    }
    
    public static String grava(Atendente atendente) throws Exception {
        int row = 0;
        
        try {
            String sql = "INSERT INTO atendente"
                    + "(matricula, nome, formacao, endereco_id)"
                    + " VALUES(?, ?, ?, ?)";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, atendente.getMatricula());
            prepareStatement.setString(2, atendente.getNome());
            prepareStatement.setString(3, atendente.getFormacao());
            prepareStatement.setInt(4, atendente.getEndereco().getId());
            
            row = prepareStatement.executeUpdate();
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return row + " rows affected.";
    }
    
    //not in
    public static String altera(Atendente atendente, int menorMatricula,
                                int maiorMatricula) throws Exception {
        int row = 0;
        
        try {
            String sql = "UPDATE atendente"
                    + " SET nome = ?, formacao = ?, endereco_id = ?"
                    + " WHERE matricula NOT IN (?, ?)";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, atendente.getNome());
            prepareStatement.setString(2, atendente.getFormacao());
            prepareStatement.setInt(3, atendente.getEndereco().getId());
            prepareStatement.setInt(4, menorMatricula);
            prepareStatement.setInt(5, maiorMatricula);
            
            row = prepareStatement.executeUpdate();
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return row + " rows affected.";
    }
    
    //=
    public static String altera(String nome, String formacao, int enderecoId,
                                int matricula) throws Exception {
        int row = 0;
        
        try {
            String sql = "UPDATE atendente"
                    + " SET nome = ?, formacao = ?, endereco_id = ?"
                    + " WHERE matricula = ?";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, nome);
            prepareStatement.setString(2, formacao);
            prepareStatement.setInt(3, enderecoId);
            prepareStatement.setInt(4, matricula);
            
            row = prepareStatement.executeUpdate();
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return row + " rows affected.";
    }
    
    //and
    public static String altera(Atendente atendente, int matricula,
                                char letra) throws Exception {
        int row = 0;
        
        try {
            String sql = "UPDATE atendente"
                    + " SET nome = ?, formacao = ?, endereco_id = ?"
                    + " WHERE matricula = ? AND nome LIKE ?";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, atendente.getNome());
            prepareStatement.setString(2, atendente.getFormacao());
            prepareStatement.setInt(3, atendente.getEndereco().getId());
            prepareStatement.setInt(4, matricula);
            prepareStatement.setString(5, letra + "%");
            
            row = prepareStatement.executeUpdate();
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return row + " rows affected.";
    }
    
    public static String exclui(int matricula) throws Exception {
        int row = 0;
        
        try {
            String sql = "DELETE FROM atendente WHERE matricula = ?";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, matricula);
            
            row = prepareStatement.executeUpdate();
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return row + " rows affected.";
    }
    
}
