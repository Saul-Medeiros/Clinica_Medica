package testes.paciente;

import modelo.Endereco;
import modelo.Paciente;
import persistencia.PacienteDAO;

public class TestaPacienteDAOgrava {

    public static void main(String[] args) throws Exception {
        
        Paciente paciente = new Paciente();
        paciente.setCpf("77777777777"); // padrão: 11 dígitos
        paciente.setNome("Flávia");
        paciente.setTelefone("61997979797"); // padrão: 61900000000(9 dígitos)
        
        Endereco endereco = new Endereco();
        endereco.setId(5);
        paciente.setEndereco(endereco);
        
        // Object
        System.out.println(PacienteDAO.grava(paciente));
        
    }
    
}
