package testes.endereco;

import java.util.List;
import modelo.Endereco;
import persistencia.EnderecoDAO;

public class TestaEnderecoDAOleTodos {

    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        System.out.println(EnderecoDAO.leTodos());
        
    }

    /* Os métodos abaixo fazem testes em métodos sobrecarregados do pacote de persistência */

    static List<Endereco> leTodos() throws Exception {
        return EnderecoDAO.leTodos();
    }
    
    static List<Endereco> leTodosIn() throws Exception {
        return EnderecoDAO.leTodos(1, 3);
    }
    
    static List<Endereco> leTodosLike() throws Exception {
        return EnderecoDAO.leTodos('C');
    }
    
    static List<Endereco> leTodosNotBetween() throws Exception {
        return EnderecoDAO.leTodos((short)1, 3);
    }
    
}
