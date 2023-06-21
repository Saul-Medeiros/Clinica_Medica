package testes.atendente;

import persistencia.AtendenteDAO;

public class TestaAtendenteDAOalteraEQUALS {
    
    public static void main(String[] args) throws Exception {
        
        // String, String, int, int
        System.out.println(AtendenteDAO.altera("", "", 0, 0));
        
    }
    
}
