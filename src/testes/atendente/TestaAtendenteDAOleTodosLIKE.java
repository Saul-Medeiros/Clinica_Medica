package testes.atendente;

import persistencia.AtendenteDAO;

public class TestaAtendenteDAOleTodosLIKE {

    public static void main(String[] args) throws Exception {
        
        // char(primeira letra do nome)
        System.out.println(AtendenteDAO.leTodos('R'));
        
    }
    
}
