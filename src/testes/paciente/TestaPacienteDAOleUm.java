package testes.paciente;

import persistencia.PacienteDAO;

public class TestaPacienteDAOleUm {

    public static void main(String[] args) throws Exception {
        
        // String(cpf)
        System.out.println(PacienteDAO.leUm("11111111111"));
        
    }
    
}
