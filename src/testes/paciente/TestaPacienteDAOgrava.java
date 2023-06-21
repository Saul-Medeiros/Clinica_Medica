package testes.paciente;

import modelo.Endereco;
import modelo.Paciente;
import persistencia.PacienteDAO;

public class TestaPacienteDAOgrava {

    public static void main(String[] args) throws Exception {
        
        Paciente paciente = new Paciente();
        paciente.setCpf("");
        paciente.setNome("");
        paciente.setTelefone("");
        
        Endereco endereco = new Endereco();
        endereco.setId(0);
        paciente.setEndereco(endereco);
        
        // Object
        System.out.println(PacienteDAO.grava(paciente));
        
    }
    
}
