package testes.medico;

import persistencia.MedicoDAO;

public class TestaMedicoDAOleTodosNOTBETWEEN {

    public static void main(String[] args) throws Exception {
        
        // long(crm), String(crm)
        System.out.println(MedicoDAO.leTodos(33333333L, "55555555"));
        
    }
    
}
