package testes.atendente;

import persistencia.AtendenteDAO;

public class TestaAtendenteDAOleTodosNOTBETWEEN {

    public static void main(String[] args) throws Exception {
        
        // short(menorMatricula), int(maiorMatricula)
        System.out.println(AtendenteDAO.leTodos((short)111, 333));
        
    }
    
}
