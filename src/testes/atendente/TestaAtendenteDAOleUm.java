package testes.atendente;

import persistencia.AtendenteDAO;

public class TestaAtendenteDAOleUm {

    public static void main(String[] args) throws Exception {
        
        // matricula
        System.out.println(AtendenteDAO.leUm(0));
        
    }
    
}
