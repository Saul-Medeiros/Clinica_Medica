package testes.medico;

import persistencia.MedicoDAO;

public class TestaMedicoDAOleTodosIN {

    public static void main(String[] args) throws Exception {
        
        // String, String
        System.out.println(MedicoDAO.leTodos("", ""));
        
    }
    
}
