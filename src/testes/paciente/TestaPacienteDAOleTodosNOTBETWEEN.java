package testes.paciente;

import persistencia.PacienteDAO;

public class TestaPacienteDAOleTodosNOTBETWEEN {

    public static void main(String[] args) throws Exception {
        
        // long(cpf), String(cpf)
        System.out.println(PacienteDAO.leTodos(11111111111L, "33333333333"));
        
    }
    
}
