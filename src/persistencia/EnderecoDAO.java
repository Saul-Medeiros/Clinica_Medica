package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Endereco;

public class EnderecoDAO {

    protected static Connection connection;
    protected static PreparedStatement prepareStatement;
    protected static ResultSet resultSet;
    
    public static List<Endereco> leTodos() throws Exception {
        List<Endereco> listaEndereco = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM endereco";
            connection = GerenteDeConexao.getConnection();
            prepareStatement = connection.prepareStatement(sql);
            resultSet = prepareStatement.executeQuery();
            
            while (resultSet.next()) {
                Endereco endereco = new Endereco();
                
                endereco.setId(resultSet.getInt("id"));
                endereco.setRua(resultSet.getString("rua"));
                endereco.setNumero(resultSet.getInt("numero"));
                
                listaEndereco.add(endereco);
            }
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return listaEndereco;
    }
    
    // like
    public static List<Endereco> leTodos(char letra) throws Exception {
        List<Endereco> listaEndereco = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM endereco WHERE rua LIKE ?";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, letra + "%");
            
            resultSet = prepareStatement.executeQuery();
            
            while (resultSet.next()) {
                Endereco endereco = new Endereco();
                
                endereco.setId(resultSet.getInt("id"));
                endereco.setRua(resultSet.getString("rua"));
                endereco.setNumero(resultSet.getInt("numero"));
                
                listaEndereco.add(endereco);
            }
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return listaEndereco;
    }
    
    // in
    public static List<Endereco> leTodos(int menorId, int maiorId)
            throws Exception {
        List<Endereco> listaEndereco = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM endereco WHERE id IN(?, ?)";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, menorId);
            prepareStatement.setInt(2, maiorId);
            
            resultSet = prepareStatement.executeQuery();
            
            while (resultSet.next()) {
                Endereco endereco = new Endereco();
                
                endereco.setId(resultSet.getInt("id"));
                endereco.setRua(resultSet.getString("rua"));
                endereco.setNumero(resultSet.getInt("numero"));
                
                listaEndereco.add(endereco);
            }
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return listaEndereco;
    }
    
    // not between
    public static List<Endereco> leTodos(short menorId, int maiorId) 
            throws Exception {
        List<Endereco> listaEndereco = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM endereco WHERE id NOT BETWEEN ? AND ?";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, menorId);
            prepareStatement.setInt(2, maiorId);
            
            resultSet = prepareStatement.executeQuery();
            
            while (resultSet.next()) {
                Endereco endereco = new Endereco();
                
                endereco.setId(resultSet.getInt("id"));
                endereco.setRua(resultSet.getString("rua"));
                endereco.setNumero(resultSet.getInt("numero"));
                
                listaEndereco.add(endereco);
            }
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return listaEndereco;
    }
    
    public static Endereco leUm(int id) throws Exception {
        Endereco endereco = new Endereco();
        
        try {
            String sql = "SELECT * FROM endereco WHERE id = ?";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, id);
            
            resultSet = prepareStatement.executeQuery();
            
            if (resultSet.next()) {
                endereco.setId(resultSet.getInt("id"));
                endereco.setRua(resultSet.getString("rua"));
                endereco.setNumero(resultSet.getInt("numero"));
            }
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return endereco;
    }
    
    //grava
    public static String grava(Endereco endereco) throws Exception {
        int row = 0;
        
        try {
            String sql = "INSERT INTO endereco(id, rua, numero)"
                    + " VALUES(?, ?, ?)";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, endereco.getId());
            prepareStatement.setString(2, endereco.getRua());
            prepareStatement.setInt(3, endereco.getNumero());
            
            row = prepareStatement.executeUpdate();
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return row + " rows affected.";
    }

    //not in
    public static String altera(String rua, int numero, int menorId,
                                int maiorId) throws Exception {
        int row = 0;
        
        try {
            String sql = "UPDATE endereco"
                    + " SET rua = ?, numero = ?"
                    + " WHERE id NOT IN (?, ?)";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, rua);
            prepareStatement.setInt(2, numero);
            prepareStatement.setInt(3, menorId);
            prepareStatement.setInt(4, maiorId);
            
            row = prepareStatement.executeUpdate();
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return row + " rows affected.";
    }
    
    //=
    public static String altera(Endereco endereco, int id) throws Exception {
        int row = 0;
        
        try {
            String sql = "UPDATE endereco"
                    + " SET rua = ?, numero = ?"
                    + " WHERE id = ?";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, endereco.getRua());
            prepareStatement.setInt(2, endereco.getNumero());
            prepareStatement.setInt(3, id);
            
            row = prepareStatement.executeUpdate();
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return row + " rows affected.";
    }
    
    //and
    public static String altera(Endereco endereco, int id, String ruaAntiga)
            throws Exception {
        int row = 0;
        
        try {
            String sql = "UPDATE endereco"
                    + " SET rua = ?, numero = ?"
                    + " WHERE id = ? AND rua = ?";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, endereco.getRua());
            prepareStatement.setInt(2, endereco.getNumero());
            prepareStatement.setInt(3, id);
            prepareStatement.setString(4, ruaAntiga);
            
            row = prepareStatement.executeUpdate();
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return row + " rows affected.";
    }
    
    //exclui
    public static String exclui(int id) throws Exception {
        int row = 0;
        
        try {
            String sql = "DELETE FROM endereco WHERE id = ?";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, id);
            
            row = prepareStatement.executeUpdate();
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return row + " rows affected.";
    }
    
}
