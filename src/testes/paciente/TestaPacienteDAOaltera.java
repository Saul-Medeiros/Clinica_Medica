package testes.paciente;

import modelo.*;
import persistencia.PacienteDAO;

public class TestaPacienteDAOaltera {

    public static void main(String[] args) throws Exception {
        // TODO code applciation logic here
        System.out.println(alteraAnd());
        
    }

    /* Os métodos abaixo fazem testes em métodos sobrecarregados do pacote de persistência */

    static String alteraAnd() throws Exception {
        Paciente paciente = new Paciente();
        paciente.setNome("Flávia");
        paciente.setTelefone("61997979797"); // 9 digits
        
        Endereco endereco = new Endereco();
        endereco.setId(5);
        
        paciente.setEndereco(endereco);
        
        return PacienteDAO.altera(paciente, 44444444444L, "Priscila");
    }

    static String alteraEquals() throws Exception {
        Paciente paciente = new Paciente();
        paciente.setNome("Flávia");
        paciente.setTelefone("61997979797");
        
        Endereco endereco = new Endereco();
        endereco.setId(5);
        
        paciente.setEndereco(endereco);
        
        return PacienteDAO.altera(paciente, "44444444444");
    }

    static String alteraNotIn() throws Exception {
        Paciente paciente = new Paciente();
        paciente.setNome("Flávia");
        paciente.setTelefone("61997979797");
        
        Endereco endereco = new Endereco();
        endereco.setId(5);
        
        paciente.setEndereco(endereco);
        
        return PacienteDAO.altera(paciente, "11111111111", "33333333333");
        
    }
    
}
