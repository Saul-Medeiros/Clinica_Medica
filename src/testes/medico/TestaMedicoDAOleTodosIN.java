package testes.medico;

import persistencia.MedicoDAO;

public class TestaMedicoDAOleTodosIN {

    public static void main(String[] args) throws Exception {
        
        // String(crm), String(crm)
        System.out.println(MedicoDAO.leTodos("11111111", "33333333"));
        
    }
    
}
