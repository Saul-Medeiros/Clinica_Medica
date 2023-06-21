package testes.paciente;

import persistencia.PacienteDAO;

public class TestaPacienteDAOleTodosIN {

    public static void main(String[] args) throws Exception {
        
        // String, String
        System.out.println(PacienteDAO.leTodos("", ""));
        
    }
    
}
