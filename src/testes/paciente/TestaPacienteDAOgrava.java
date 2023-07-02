package testes.paciente;

import modelo.*;
import persistencia.PacienteDAO;

public class TestaPacienteDAOgrava {

    public static void main(String[] args) throws Exception {
        
        Paciente paciente = new Paciente();
        paciente.setCpf("77777777777"); // 11 digits
        paciente.setNome("Flávia");
        paciente.setTelefone("61997979797"); // 9 digits
        
        Endereco endereco = new Endereco();
        endereco.setId(5);
        paciente.setEndereco(endereco);
        
        System.out.println(PacienteDAO.grava(paciente));
        
    }
    
}
