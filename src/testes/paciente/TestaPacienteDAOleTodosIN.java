package testes.paciente;

import persistencia.PacienteDAO;

public class TestaPacienteDAOleTodosIN {

    public static void main(String[] args) throws Exception {
        
        // String(cpf), String(cpf)
        System.out.println(PacienteDAO.leTodos("11111111111", "33333333333"));
        
    }
    
}
