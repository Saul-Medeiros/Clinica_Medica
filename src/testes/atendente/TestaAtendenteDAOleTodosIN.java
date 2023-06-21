package testes.atendente;

import persistencia.AtendenteDAO;

public class TestaAtendenteDAOleTodosIN {

    public static void main(String[] args) throws Exception {
        
        // int, int
        System.out.println(AtendenteDAO.leTodos(0, 0));
        
    }
    
}
