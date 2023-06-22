package testes.paciente;

import persistencia.PacienteDAO;

public class TestaPacienteDAOleTodosLIKE {

    public static void main(String[] args) throws Exception {
        
        // char(primeira letra do nome do paciente)
        System.out.println(PacienteDAO.leTodos('P'));
        
    }
    
}
