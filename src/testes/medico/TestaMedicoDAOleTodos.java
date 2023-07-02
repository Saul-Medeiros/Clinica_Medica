package testes.medico;

import java.util.List;
import modelo.Medico;
import persistencia.MedicoDAO;

public class TestaMedicoDAOleTodos {

    public static void main(String[] args) throws Exception {
        
        System.out.println(leTodos());
        
    }
    
    /* Os métodos abaixo fazem testes em métodos sobrecarregados do pacote de persistência */

    static List<Medico> leTodos() throws Exception {
        return MedicoDAO.leTodos();
    }
    
    static List<Medico> leTodosIn() throws Exception {
        return MedicoDAO.leTodos("11111111", "33333333");
    }
    
    static List<Medico> leTodosLike() throws Exception {
        return MedicoDAO.leTodos('V');
    }

    static List<Medico> leTodosNotBetween() throws Exception {
        return MedicoDAO.leTodos(33333333L, "55555555");
    }
}
