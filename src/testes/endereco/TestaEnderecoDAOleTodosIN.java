package testes.endereco;

import persistencia.EnderecoDAO;

public class TestaEnderecoDAOleTodosIN {

    public static void main(String[] args) throws Exception {
        
        // int, int
        System.out.println(EnderecoDAO.leTodos(0, 0));
        
    }
    
}
