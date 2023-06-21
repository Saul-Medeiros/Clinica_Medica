package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Consultorio;

public class ConsultorioDAO {

    protected static Connection connection;
    protected static PreparedStatement prepareStatement;
    protected static ResultSet resultSet;
    
    public static List<Consultorio> leTodos() throws Exception {
        List<Consultorio> listaConsultorio = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM consultorio";
            connection = GerenteDeConexao.getConnection();
            prepareStatement = connection.prepareStatement(sql);
            resultSet = prepareStatement.executeQuery();
            
            while (resultSet.next()) {
                Consultorio consultorio = new Consultorio();
                
                consultorio.setNumero(resultSet.getInt("numero"));
                consultorio.setEndereco(EnderecoDAO.leUm(resultSet.getInt(
                        "endereco_id")));
                
                listaConsultorio.add(consultorio);
            }
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return listaConsultorio;
    }
    
    // like
    public static List<Consultorio> leTodos(char letra) throws Exception {
        List<Consultorio> listaConsultorio = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM consultorio c"
                    + " INNER JOIN endereco e"
                    + " ON e.id = c.endereco_id"
                    + " WHERE e.rua LIKE ?";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, letra + "%");
            
            resultSet = prepareStatement.executeQuery();
            
            while (resultSet.next()) {
                Consultorio consultorio = new Consultorio();
                
                consultorio.setNumero(resultSet.getInt("c.numero"));
                consultorio.setEndereco(EnderecoDAO.leUm(
                        resultSet.getInt("e.id")));
                
                listaConsultorio.add(consultorio);
            }
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return listaConsultorio;
    }
    
    // in
    public static List<Consultorio> leTodos(int numeroMenor, int numeroMaior)
            throws Exception {
        List<Consultorio> listaConsultorio = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM consultorio WHERE numero IN(?, ?)";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, numeroMenor);
            prepareStatement.setInt(2, numeroMaior);
            
            resultSet = prepareStatement.executeQuery();
            
            while (resultSet.next()) {
                Consultorio consultorio = new Consultorio();
                
                consultorio.setNumero(resultSet.getInt("numero"));
                consultorio.setEndereco(EnderecoDAO.leUm(resultSet.getInt(
                        "endereco_id")));
                
                listaConsultorio.add(consultorio);
            }
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return listaConsultorio;
    }
    
    // not between
    public static List<Consultorio> leTodos(short numeroMenor, int numeroMaior)
            throws Exception {
        List<Consultorio> listaConsultorio = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM consultorio"
                    + " WHERE numero NOT BETWEEN ? AND ?";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, numeroMenor);
            prepareStatement.setInt(2, numeroMaior);
            
            resultSet = prepareStatement.executeQuery();
            
            while (resultSet.next()) {
                Consultorio consultorio = new Consultorio();
                
                consultorio.setNumero(resultSet.getInt("numero"));
                consultorio.setEndereco(EnderecoDAO.leUm(resultSet.getInt(
                        "endereco_id")));
                
                listaConsultorio.add(consultorio);
            }
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return listaConsultorio;
    }
    
    public static Consultorio leUm(int numero) throws Exception {
        Consultorio consultorio = new Consultorio();
        
        try {
            String sql = "SELECT * FROM consultorio WHERE numero = ?";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, numero);
            
            resultSet = prepareStatement.executeQuery();
            
            if (resultSet.next()) {
                consultorio.setNumero(resultSet.getInt("numero"));
                consultorio.setEndereco(EnderecoDAO.leUm(resultSet.getInt(
                        "endereco_id")));
            }
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return consultorio;
    }
    
    public static String grava(int numero, int enderecoId) throws Exception {
        int row = 0;
        
        try {
            String sql = "INSERT INTO consultorio(numero, endereco_id)"
                    + " VALUES(?, ?)";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, numero);
            prepareStatement.setInt(2, enderecoId);
            
            row = prepareStatement.executeUpdate();
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return row + " rows affected.";
    }
    
    //not in
    public static String altera(int enderecoId, int menorNumero,
                                int maiorNumero) throws Exception {
        int row = 0;
        
        try {
            String sql = "UPDATE consultorio"
                    + " SET endereco_id = ?"
                    + " WHERE numero NOT IN (?, ?)";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, enderecoId);
            prepareStatement.setInt(2, menorNumero);
            prepareStatement.setInt(3, maiorNumero);
            
            row = prepareStatement.executeUpdate();
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return row + " rows affected.";
    }
    
    // equals
    public static String altera(int enderecoId, int numero) throws Exception {
        int row = 0;
        
        try {
            String sql = "UPDATE consultorio SET endereco_id = ?"
                    + " WHERE numero = ?";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, enderecoId);
            prepareStatement.setInt(2, numero);
            
            row = prepareStatement.executeUpdate();
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return row + " rows affected.";
    }
    
    //and
    public static String altera(int enderecoId, Consultorio consultorio)
            throws Exception {
        int row = 0;
        
        try {
            String sql = "UPDATE consultorio"
                    + " SET endereco_id = ?"
                    + " WHERE numero = ? AND endereco_id = ?";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, enderecoId);
            prepareStatement.setInt(2, consultorio.getNumero());
            prepareStatement.setInt(3, consultorio.getEndereco().getId());
            
            row = prepareStatement.executeUpdate();
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return row + " rows affected.";
    }
    
    //exclui
    public static String exclui(int numero) throws Exception {
        int row = 0;
        
        try {
            String sql = "DELETE FROM consultorio WHERE numero = ?";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, numero);
            
            row = prepareStatement.executeUpdate();
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return row + " rows affected.";
    }
    
}
