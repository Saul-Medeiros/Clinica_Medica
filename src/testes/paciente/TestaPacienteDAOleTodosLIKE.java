package testes.paciente;

import persistencia.PacienteDAO;

public class TestaPacienteDAOleTodosLIKE {

    public static void main(String[] args) throws Exception {
        
        // char
        System.out.println(PacienteDAO.leTodos('.'));
        
    }
    
}
