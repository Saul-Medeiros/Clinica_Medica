package testes.consulta;

import java.util.List;
import modelo.Consulta;
import persistencia.ConsultaDAO;

public class TestaConsultaDAOleTodos {

    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        System.out.println(leTodos());
        
    }

    /* Os métodos abaixo fazem testes em métodos sobrecarregados do pacote de persistência */

    static List<Consulta> leTodos() throws Exception {
        return ConsultaDAO.leTodos();
    }
    
    static List<Consulta> leTodosIn() throws Exception {
        return ConsultaDAO.leTodos(1, 3);
    }
    
    static List<Consulta> leTodosLike() throws Exception {
        return ConsultaDAO.leTodos('G');
    }
    
    static List<Consulta> leTodosNotBetween() throws Exception {
        return ConsultaDAO.leTodos((short)1, 3);
    }
    
}
