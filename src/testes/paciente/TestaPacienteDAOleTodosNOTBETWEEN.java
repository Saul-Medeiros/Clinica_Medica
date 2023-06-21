package testes.paciente;

import persistencia.PacienteDAO;

public class TestaPacienteDAOleTodosNOTBETWEEN {

    public static void main(String[] args) throws Exception {
        
        // long, String
        System.out.println(PacienteDAO.leTodos(0L, ""));
        
    }
    
}
