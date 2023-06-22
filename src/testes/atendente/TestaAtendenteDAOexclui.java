package testes.atendente;

import persistencia.AtendenteDAO;

public class TestaAtendenteDAOexclui {

    public static void main(String[] args) throws Exception {
        
        // int(matricula)
        System.out.println(AtendenteDAO.exclui(555));
        
    }
    
}
