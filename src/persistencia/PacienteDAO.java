package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Paciente;

public class PacienteDAO {

    protected static Connection connection;
    protected static PreparedStatement prepareStatement;
    protected static ResultSet resultSet;
    
    public static List<Paciente> leTodos() throws Exception {
        List<Paciente> listaPaciente = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM paciente";
            connection = GerenteDeConexao.getConnection();
            prepareStatement = connection.prepareStatement(sql);
            resultSet = prepareStatement.executeQuery();
            
            while (resultSet.next()) {
                Paciente paciente = new Paciente();
                
                paciente.setCpf(resultSet.getString("cpf"));
                paciente.setEndereco(EnderecoDAO.leUm(resultSet.getInt(
                        "endereco_id")));
                paciente.setNome(resultSet.getString("nome"));
                paciente.setTelefone(resultSet.getString("telefone"));
                
                listaPaciente.add(paciente);
            }
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return listaPaciente;
    }
    
    // like
    public static List<Paciente> leTodos(char letra) throws Exception {
        List<Paciente> listaPaciente = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM paciente WHERE nome LIKE ?";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, letra + "%");
            
            resultSet = prepareStatement.executeQuery();
            
            while (resultSet.next()) {
                Paciente paciente = new Paciente();
                
                paciente.setCpf(resultSet.getString("cpf"));
                paciente.setEndereco(EnderecoDAO.leUm(resultSet.getInt(
                        "endereco_id")));
                paciente.setNome(resultSet.getString("nome"));
                paciente.setTelefone(resultSet.getString("telefone"));
                
                listaPaciente.add(paciente);
            }
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return listaPaciente;
    }
    
    // in
    public static List<Paciente> leTodos(String cpfMenor, String cpfMaior)
            throws Exception {
        List<Paciente> listaPaciente = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM paciente WHERE cpf IN(?, ?)";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, cpfMenor);
            prepareStatement.setString(2, cpfMaior);
            
            resultSet = prepareStatement.executeQuery();
            
            while (resultSet.next()) {
                Paciente paciente = new Paciente();
                
                paciente.setCpf(resultSet.getString("cpf"));
                paciente.setEndereco(EnderecoDAO.leUm(resultSet.getInt(
                        "endereco_id")));
                paciente.setNome(resultSet.getString("nome"));
                paciente.setTelefone(resultSet.getString("telefone"));
                
                listaPaciente.add(paciente);
            }
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return listaPaciente;
    }
    
    // not between
    public static List<Paciente> leTodos(long cpfMenor, String cpfMaior)
            throws Exception {
        List<Paciente> listaPaciente = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM paciente WHERE cpf NOT BETWEEN ? AND ?";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setLong(1, cpfMenor);
            prepareStatement.setString(2, cpfMaior);
            
            resultSet = prepareStatement.executeQuery();
            
            while (resultSet.next()) {
                Paciente paciente = new Paciente();
                
                paciente.setCpf(resultSet.getString("cpf"));
                paciente.setEndereco(EnderecoDAO.leUm(resultSet.getInt(
                        "endereco_id")));
                paciente.setNome(resultSet.getString("nome"));
                paciente.setTelefone(resultSet.getString("telefone"));
                
                listaPaciente.add(paciente);
            }
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return listaPaciente;
    }
    
    public static Paciente leUm(String cpf) throws Exception {
        Paciente paciente = new Paciente();
        
        try {
            String sql = "SELECT * FROM paciente WHERE cpf = ?";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, cpf);
            
            resultSet = prepareStatement.executeQuery();
            
            if (resultSet.next()) {
                paciente.setCpf(resultSet.getString("cpf"));
                paciente.setEndereco(EnderecoDAO.leUm(resultSet.getInt(
                        "endereco_id")));
                paciente.setNome(resultSet.getString("nome"));
                paciente.setTelefone(resultSet.getString("telefone"));
            }
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return paciente;
    }
    
    public static String grava(Paciente paciente) throws Exception {
        int row = 0;
        
        try {
            String sql = "INSERT INTO paciente"
                    + "(cpf, nome, telefone, endereco_id)"
                    + " VALUES(?, ?, ?, ?)";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, paciente.getCpf());
            prepareStatement.setString(2, paciente.getNome());
            prepareStatement.setString(3, paciente.getTelefone());
            prepareStatement.setInt(4, paciente.getEndereco().getId());
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return row + " rows affected.";
    }
    
    //not in
    public static String altera(Paciente paciente, String menorCpf,
                                String maiorCpf) throws Exception {
        int row = 0;
        
        try {
            String sql = "UPDATE paciente"
                    + " SET nome = ?, telefone = ?, endereco_id = ?"
                    + " WHERE cpf NOT IN(?, ?)";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, paciente.getNome());
            prepareStatement.setString(2, paciente.getTelefone());
            prepareStatement.setInt(3, paciente.getEndereco().getId());
            prepareStatement.setString(4, menorCpf);
            prepareStatement.setString(5, maiorCpf);
            
            row = prepareStatement.executeUpdate();
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return row + " rows affected.";
    }
    
    // equals
    public static String altera(Paciente paciente, String cpf)
            throws Exception {
        int row = 0;
        
        try {
            String sql = "UPDATE paciente"
                    + " SET nome = ?, telefone = ?, endereco_id = ?"
                    + " WHERE cpf = ?";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, paciente.getNome());
            prepareStatement.setString(2, paciente.getTelefone());
            prepareStatement.setInt(3, paciente.getEndereco().getId());
            prepareStatement.setString(4, cpf);
            
            row = prepareStatement.executeUpdate();
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return row + " rows affected.";
    }
    
    //and
    public static String altera(Paciente paciente, long cpf, String antigoNome)
            throws Exception {
        int row = 0;
        
        try {
            String sql = "UPDATE paciente"
                    + " SET nome = ?, telefone = ?, endereco_id = ?"
                    + " WHERE cpf = ? AND nome = ?";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, paciente.getNome());
            prepareStatement.setString(2, paciente.getTelefone());
            prepareStatement.setInt(3, paciente.getEndereco().getId());
            prepareStatement.setLong(4, cpf);
            prepareStatement.setString(5, antigoNome);
            
            row = prepareStatement.executeUpdate();
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return row + " rows affected.";
    }
    
    //exclui
    public static String exclui(String cpf) throws Exception {
        int row = 0;
        
        try {
            String sql = "DELETE FROM paciente WHERE cpf = ?";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, cpf);
            
            row = prepareStatement.executeUpdate();
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return row + " rows affected.";
    }
    
}
