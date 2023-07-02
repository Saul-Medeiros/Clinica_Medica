package testes.atendente;

import java.util.List;
import modelo.Atendente;
import persistencia.AtendenteDAO;

public class TestaAtendenteDAOleTodos {

    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        System.out.println(leTodos());
        
    }

    /* Os métodos abaixo fazem testes em métodos sobrecarregados do pacote de persistência */

    static List<Atendente> leTodos() throws Exception {
        return AtendenteDAO.leTodos();
    }

    static List<Atendente> leTodosIn() throws Exception {
        return AtendenteDAO.leTodos(111, 333);
    }

    static List<Atendente> leTodosLike() throws Exception {
        return AtendenteDAO.leTodos('R');
    }

    static List<Atendente> leTodosNotBetween() throws Exception {
        return AtendenteDAO.leTodos((short)111, 333);
    }
    
}
