package testes.paciente;

import modelo.Endereco;
import modelo.Paciente;
import persistencia.PacienteDAO;

public class TestaPacienteDAOalteraNOTIN {

    public static void main(String[] args) throws Exception {
        
        Paciente paciente = new Paciente();
        paciente.setNome("Flávia");
        paciente.setTelefone("61997979797"); // padrão: 61900000000(9 dígitos)
        
        Endereco endereco = new Endereco();
        endereco.setId(5);
        paciente.setEndereco(endereco);
        
        // Object[SET actions]
        // String(cpf), String(cpf) [WHERE action]
        System.out.println(PacienteDAO.altera(
                paciente, "11111111111", "33333333333"));
        
    }
    
}
