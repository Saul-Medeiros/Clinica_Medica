package testes.paciente;

import modelo.Endereco;
import modelo.Paciente;
import persistencia.PacienteDAO;

public class TestaPacienteDAOalteraAND {

    public static void main(String[] args) throws Exception {
        
        Paciente paciente = new Paciente();
        paciente.setNome("");
        paciente.setTelefone("");
        
        Endereco endereco = new Endereco();
        endereco.setId(0);
        paciente.setEndereco(endereco);
        
        // Object[SET actions]
        // long, String[WHERE action]
        System.out.println(PacienteDAO.altera(paciente, 0L, ""));
        
    }
    
}
