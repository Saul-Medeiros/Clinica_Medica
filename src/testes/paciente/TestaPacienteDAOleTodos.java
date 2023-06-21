package testes.paciente;

import persistencia.PacienteDAO;

public class TestaPacienteDAOleTodos {

    public static void main(String[] args) throws Exception {
        
        System.out.println(PacienteDAO.leTodos());
        
    }
    
}
