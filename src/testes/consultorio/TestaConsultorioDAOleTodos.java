package testes.consultorio;

import java.util.List;
import modelo.Consultorio;
import persistencia.ConsultorioDAO;

public class TestaConsultorioDAOleTodos {

    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        System.out.println(leTodos());
        
    }

    /* As classes abaixo fazem testes em métodos sobrecarregados */

    static List<Consultorio> leTodos() throws Exception {
        return ConsultorioDAO.leTodos();
    }
    
    static List<Consultorio> leTodosIn() throws Exception {
        return ConsultorioDAO.leTodos(35, 40);
    }
    
    static List<Consultorio> leTodosLike() throws Exception {
        return ConsultorioDAO.leTodos('C');
    }
    
    static List<Consultorio> leTodosNotBetween() throws Exception {
        return ConsultorioDAO.leTodos((short)30, 40);
    }
    
}
