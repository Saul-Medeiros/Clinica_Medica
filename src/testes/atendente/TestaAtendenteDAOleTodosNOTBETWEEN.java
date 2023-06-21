package testes.atendente;

import persistencia.AtendenteDAO;

public class TestaAtendenteDAOleTodosNOTBETWEEN {

    public static void main(String[] args) throws Exception {
        
        // short, int
        System.out.println(AtendenteDAO.leTodos((short)0, 0));
        
    }
    
}
