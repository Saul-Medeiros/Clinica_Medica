package testes.medico;

import persistencia.MedicoDAO;

public class TestaMedicoDAOleTodosNOTBETWEEN {

    public static void main(String[] args) throws Exception {
        
        // long, String
        System.out.println(MedicoDAO.leTodos((long)0, ""));
        
    }
    
}
