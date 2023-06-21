package testes.atendente;

import persistencia.AtendenteDAO;

public class TestaAtendenteDAOleTodosLIKE {

    public static void main(String[] args) throws Exception {
        
        // char
        System.out.println(AtendenteDAO.leTodos('.'));
        
    }
    
}
