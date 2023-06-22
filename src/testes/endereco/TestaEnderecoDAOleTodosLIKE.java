package testes.endereco;

import persistencia.EnderecoDAO;

public class TestaEnderecoDAOleTodosLIKE {

    public static void main(String[] args) throws Exception {
        
        // char(primeira letra da rua)
        System.out.println(EnderecoDAO.leTodos('C'));
        
    }
    
}
