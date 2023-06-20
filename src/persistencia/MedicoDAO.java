package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Medico;

public class MedicoDAO {

    protected static Connection connection;
    protected static PreparedStatement prepareStatement;
    protected static ResultSet resultSet;
    
    public static List<Medico> leTodos() throws Exception {
        List<Medico> listaMedico = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM medico";
            connection = GerenteDeConexao.getConnection();
            prepareStatement = connection.prepareStatement(sql);
            resultSet = prepareStatement.executeQuery();
            
            while (resultSet.next()) {
                Medico medico = new Medico();
                
                medico.setCrm(resultSet.getString("crm"));
                medico.setNome(resultSet.getString("nome"));
                medico.setEspecialidade(resultSet.getString("especialidade"));
                medico.setEndereco(EnderecoDAO.leUm(resultSet.getInt(
                        "endereco_id")));
                medico.setConsultorio(ConsultorioDAO.leUm(resultSet.getInt(
                        "consultorio_numero")));
                
                listaMedico.add(medico);
            }
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return listaMedico;
    }
    
    // like
    public static List<Medico> leTodos(char letra) throws Exception {
        List<Medico> listaMedico = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM medico WHERE nome LIKE ?";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, letra + "%");
            
            resultSet = prepareStatement.executeQuery();
            
            while (resultSet.next()) {
                Medico medico = new Medico();
                
                medico.setCrm(resultSet.getString("crm"));
                medico.setNome(resultSet.getString("nome"));
                medico.setEspecialidade(resultSet.getString("especialidade"));
                medico.setEndereco(EnderecoDAO.leUm(resultSet.getInt(
                        "endereco_id")));
                medico.setConsultorio(ConsultorioDAO.leUm(resultSet.getInt(
                        "consultorio_numero")));
                
                listaMedico.add(medico);
            }
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return listaMedico;
    }
    
    // in
    public static List<Medico> leTodos(String crmMenor, String crmMaior)
            throws Exception {
        List<Medico> listaMedico = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM medico WHERE crm IN(?, ?)";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, crmMenor);
            prepareStatement.setString(2, crmMaior);
            
            resultSet = prepareStatement.executeQuery();
            
            while (resultSet.next()) {
                Medico medico = new Medico();
                
                medico.setCrm(resultSet.getString("crm"));
                medico.setNome(resultSet.getString("nome"));
                medico.setEspecialidade(resultSet.getString("especialidade"));
                medico.setEndereco(EnderecoDAO.leUm(resultSet.getInt(
                        "endereco_id")));
                medico.setConsultorio(ConsultorioDAO.leUm(resultSet.getInt(
                        "consultorio_numero")));
                
                listaMedico.add(medico);
            }
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return listaMedico;
    }
    
    // not between
    public static List<Medico> leTodos(long crmMenor, String crmMaior)
            throws Exception {
        List<Medico> listaMedico = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM medico WHERE crm NOT BETWEEN ? AND ?";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, String.valueOf(crmMenor));
            prepareStatement.setString(2, crmMaior);
            
            resultSet = prepareStatement.executeQuery();
            
            while (resultSet.next()) {
                Medico medico = new Medico();
                
                medico.setCrm(resultSet.getString("crm"));
                medico.setNome(resultSet.getString("nome"));
                medico.setEspecialidade(resultSet.getString("especialidade"));
                medico.setEndereco(EnderecoDAO.leUm(resultSet.getInt(
                        "endereco_id")));
                medico.setConsultorio(ConsultorioDAO.leUm(resultSet.getInt(
                        "consultorio_numero")));
                
                listaMedico.add(medico);
            }
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return listaMedico;
    }
    
    public static Medico leUm(String crm) throws Exception {
        Medico medico = new Medico();
        
        try {
            String sql = "SELECT * FROM medico WHERE crm = ?";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, crm);
            
            resultSet = prepareStatement.executeQuery();
            
            if (resultSet.next()) {
                medico.setCrm(resultSet.getString("crm"));
                medico.setNome(resultSet.getString("nome"));
                medico.setEspecialidade(resultSet.getString("especialidade"));
                medico.setEndereco(EnderecoDAO.leUm(resultSet.getInt(
                        "endereco_id")));
                medico.setConsultorio(ConsultorioDAO.leUm(resultSet.getInt(
                        "consultorio_numero")));
            }
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return medico;
    }
    
    //grava
    public static String grava(Medico medico) throws Exception {
        int row = 0;
        
        try {
            String sql = "INSERT INTO medico(crm, nome, especialidade,"
                    + " endereco_id, consultorio_numero)"
                    + " VALUES(?, ?, ?, ?, ?)";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, medico.getCrm());
            prepareStatement.setString(2, medico.getNome());
            prepareStatement.setString(3, medico.getEspecialidade());
            prepareStatement.setInt(4, medico.getEndereco().getId());
            prepareStatement.setInt(5, medico.getConsultorio().getNumero());
            
            row = prepareStatement.executeUpdate();
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return row + " rows affected.";
    }
    
    //not in
    public static String altera(Medico medico, String menorCrm, String maiorCrm)
            throws Exception {
        int row = 0;
        
        try {
            String sql = "UPDATE medico"
                    + " SET nome = ?, especialidade = ?, endereco_id = ?,"
                    + " consultorio_numero = ? WHERE crm NOT IN(?, ?)";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, medico.getNome());
            prepareStatement.setString(2, medico.getEspecialidade());
            prepareStatement.setInt(3, medico.getEndereco().getId());
            prepareStatement.setInt(4, medico.getConsultorio().getNumero());
            prepareStatement.setString(5, menorCrm);
            prepareStatement.setString(6, maiorCrm);
            
            row = prepareStatement.executeUpdate();
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return row + " rows affected.";
    }
    
    //=
    public static String altera(Medico medico, String crm) throws Exception {
        int row = 0;
        
        try {
            String sql = "UPDATE medico"
                    + " SET nome = ?, especialidade = ?, endereco_id = ?,"
                    + " consultorio_numero = ? WHERE crm = ?";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, medico.getNome());
            prepareStatement.setString(2, medico.getEspecialidade());
            prepareStatement.setInt(3, medico.getEndereco().getId());
            prepareStatement.setInt(4, medico.getConsultorio().getNumero());
            prepareStatement.setString(5, crm);
            
            row = prepareStatement.executeUpdate();
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return row + " rows affected.";
    }
    
    //and
    public static String altera(Medico medico, long crm, String nome) 
            throws Exception {
        int row = 0;
        
        try {
            String sql = "UPDATE medico"
                    + " SET nome = ?, especialidade = ?, endereco_id = ?,"
                    + " consultorio_numero = ? WHERE crm = ? AND nome = ?";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, medico.getNome());
            prepareStatement.setString(2, medico.getEspecialidade());
            prepareStatement.setInt(3, medico.getEndereco().getId());
            prepareStatement.setInt(4, medico.getConsultorio().getNumero());
            prepareStatement.setLong(5, crm);
            prepareStatement.setString(6, nome);
            
            row = prepareStatement.executeUpdate();
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return row + " rows affected.";
    }
    
    //exclui
    public static String exclui(String crm) throws Exception {
        int row = 0;
        
        try {
            String sql = "DELETE FROM medico WHERE crm = ?";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, crm);
            
            row = prepareStatement.executeUpdate();
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return row + " rows affected.";
    }
    
}
