package testes.atendente;

import persistencia.AtendenteDAO;

public class TestaAtendenteDAOleTodosIN {

    public static void main(String[] args) throws Exception {
        
        // int(menorMatricula), int(maiorMatricula)
        System.out.println(AtendenteDAO.leTodos(111, 333));
        
    }
    
}
