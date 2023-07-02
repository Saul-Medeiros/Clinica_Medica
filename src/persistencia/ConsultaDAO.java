package persistencia;

import java.sql.*;
import java.util.*;
import modelo.Consulta;

public class ConsultaDAO {

    protected static Connection connection;
    protected static PreparedStatement prepareStatement;
    protected static ResultSet resultSet;
    
    public static List<Consulta> leTodos() throws Exception {
        List<Consulta> listaConsulta = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM consulta";
            connection = GerenteDeConexao.getConnection();
            prepareStatement = connection.prepareStatement(sql);
            resultSet = prepareStatement.executeQuery();
            
            while (resultSet.next()) {
                Consulta consulta = new Consulta();
                
                consulta.setNumero(resultSet.getInt("numero"));
                consulta.setData(resultSet.getString("data"));
                consulta.setHorario(resultSet.getString("horario"));
                consulta.setAtendente(AtendenteDAO.leUm(resultSet.getInt(
                        "atendente_matricula")));
                consulta.setPaciente(PacienteDAO.leUm(resultSet.getString(
                        "paciente_cpf")));
                consulta.setMedico(MedicoDAO.leUm(resultSet.getString(
                        "medico_crm")));
                
                listaConsulta.add(consulta);
            }
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return listaConsulta;
    }
    
    public static List<Consulta> leTodos(char letra) throws Exception {
        List<Consulta> listaConsulta = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM consulta c"
                    + " INNER JOIN medico m"
                    + " ON m.crm = c.medico_crm"
                    + " WHERE m.nome LIKE ?";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, letra + "%");
            
            resultSet = prepareStatement.executeQuery();
            
            while (resultSet.next()) {
                Consulta consulta = new Consulta();
                
                consulta.setNumero(resultSet.getInt("c.numero"));
                consulta.setData(resultSet.getString("c.data"));
                consulta.setHorario(resultSet.getString("c.horario"));
                consulta.setAtendente(AtendenteDAO.leUm(resultSet.getInt(
                        "c.atendente_matricula")));
                consulta.setPaciente(PacienteDAO.leUm(resultSet.getString(
                        "c.paciente_cpf")));
                consulta.setMedico(MedicoDAO.leUm(resultSet.getString(
                        "c.medico_crm")));
                
                listaConsulta.add(consulta);
            }
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return listaConsulta;
    }
    
    public static List<Consulta> leTodos(int numeroMenor, int numeroMaior)
            throws Exception {
        List<Consulta> listaConsulta = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM consulta WHERE numero IN(?, ?)";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, numeroMenor);
            prepareStatement.setInt(2, numeroMaior);
            
            resultSet = prepareStatement.executeQuery();
            
            while (resultSet.next()) {
                Consulta consulta = new Consulta();
                
                consulta.setNumero(resultSet.getInt("numero"));
                consulta.setData(resultSet.getString("data"));
                consulta.setHorario(resultSet.getString("horario"));
                consulta.setAtendente(AtendenteDAO.leUm(resultSet.getInt(
                        "atendente_matricula")));
                consulta.setPaciente(PacienteDAO.leUm(resultSet.getString(
                        "paciente_cpf")));
                consulta.setMedico(MedicoDAO.leUm(resultSet.getString(
                        "medico_crm")));
                
                listaConsulta.add(consulta);
            }
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return listaConsulta;
    }
    
    public static List<Consulta> leTodos(short numeroMenor, int numeroMaior) 
            throws Exception {
        List<Consulta> listaConsulta = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM consulta"
                    + " WHERE numero NOT BETWEEN ? AND ?";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, numeroMenor);
            prepareStatement.setInt(2, numeroMaior);
            
            resultSet = prepareStatement.executeQuery();
            
            while (resultSet.next()) {
                Consulta consulta = new Consulta();
                
                consulta.setNumero(resultSet.getInt("numero"));
                consulta.setData(resultSet.getString("data"));
                consulta.setHorario(resultSet.getString("horario"));
                consulta.setAtendente(AtendenteDAO.leUm(resultSet.getInt(
                        "atendente_matricula")));
                consulta.setPaciente(PacienteDAO.leUm(resultSet.getString(
                        "paciente_cpf")));
                consulta.setMedico(MedicoDAO.leUm(resultSet.getString(
                        "medico_crm")));
                
                listaConsulta.add(consulta);
            }
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return listaConsulta;
    }
    
    public static Consulta leUm(int numero) throws Exception {
        Consulta consulta = new Consulta();
        
        try {
            String sql = "SELECT * FROM consulta WHERE numero = ?";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, numero);
            
            resultSet = prepareStatement.executeQuery();
            
            if (resultSet.next()) {
                consulta.setNumero(resultSet.getInt("numero"));
                consulta.setData(resultSet.getString("data"));
                consulta.setHorario(resultSet.getString("horario"));
                consulta.setAtendente(AtendenteDAO.leUm(resultSet.getInt(
                        "atendente_matricula")));
                consulta.setPaciente(PacienteDAO.leUm(resultSet.getString(
                        "paciente_cpf")));
                consulta.setMedico(MedicoDAO.leUm(resultSet.getString(
                        "medico_crm")));
            }
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return consulta;
    }
    
    public static String grava(Consulta consulta) throws Exception {
        int row = 0;
        
        try {
            String sql = "INSERT INTO consulta"
                    + "(numero, data, horario, atendente_matricula,"
                    + " paciente_cpf, medico_crm) VALUES(?, ?, ?, ?, ?, ?)";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, consulta.getNumero());
            prepareStatement.setString(2, consulta.sqlData());
            prepareStatement.setString(3, consulta.getHorario());
            prepareStatement.setInt(4, consulta.getAtendente().getMatricula());
            prepareStatement.setString(5, consulta.getPaciente().getCpf());
            prepareStatement.setString(6, consulta.getMedico().getCrm());
            
            row = prepareStatement.executeUpdate();
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return row + " rows affected.";
    }
    
    public static String altera(Consulta consulta, int menorNumero,
                                int maiorNumero) throws Exception {
        int row = 0;
        
        try {
            String sql = "UPDATE consulta SET data = ?, horario = ?,"
                    + " atendente_matricula = ?, paciente_cpf = ?,"
                    + " medico_crm = ? WHERE numero NOT IN (?, ?)";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, consulta.sqlData());
            prepareStatement.setString(2, consulta.getHorario());
            prepareStatement.setInt(3, consulta.getAtendente().getMatricula());
            prepareStatement.setString(4, consulta.getPaciente().getCpf());
            prepareStatement.setString(5, consulta.getMedico().getCrm());
            prepareStatement.setInt(6, menorNumero);
            prepareStatement.setInt(7, maiorNumero);
            
            row = prepareStatement.executeUpdate();
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return row + " rows affected.";
    }
    
    public static String altera(Consulta consulta, int numero) 
            throws Exception {
        int row = 0;
        
        try {
            String sql = "UPDATE consulta SET data = ?, horario = ?,"
                    + " atendente_matricula = ?, paciente_cpf = ?,"
                    + " medico_crm = ? WHERE numero = ?";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, consulta.sqlData());
            prepareStatement.setString(2, consulta.getHorario());
            prepareStatement.setInt(3, consulta.getAtendente().getMatricula());
            prepareStatement.setString(4, consulta.getPaciente().getCpf());
            prepareStatement.setString(5, consulta.getMedico().getCrm());
            prepareStatement.setInt(6, numero);
            
            row = prepareStatement.executeUpdate();
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return row + " rows affected.";
    }
    
    public static String altera(Consulta consulta, int numero, String horario)
            throws Exception {
        int row = 0;
        
        try {
            String sql = "UPDATE consulta SET data = ?, horario = ?,"
                    + " atendente_matricula = ?, paciente_cpf = ?,"
                    + " medico_crm = ? WHERE numero = ? AND horario = ?";
            connection = GerenteDeConexao.getConnection();
            
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, consulta.sqlData());
            prepareStatement.setString(2, consulta.getHorario());
            prepareStatement.setInt(3, consulta.getAtendente().getMatricula());
            prepareStatement.setString(4, consulta.getPaciente().getCpf());
            prepareStatement.setString(5, consulta.getMedico().getCrm());
            prepareStatement.setInt(6, numero);
            prepareStatement.setString(7, horario);
            
            row = prepareStatement.executeUpdate();
            
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return row + " rows affected.";
    }
    
    public static String exclui(int numero) throws Exception {
        int row = 0;
        
        try {
            String sql = "DELETE FROM consulta WHERE numero = ?";
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
