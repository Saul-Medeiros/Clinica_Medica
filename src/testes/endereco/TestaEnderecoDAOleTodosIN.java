package testes.endereco;

import persistencia.EnderecoDAO;

public class TestaEnderecoDAOleTodosIN {

    public static void main(String[] args) throws Exception {
        
        // int(id), int(id)
        System.out.println(EnderecoDAO.leTodos(1, 3));
        
    }
    
}
