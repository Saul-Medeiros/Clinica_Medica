package testes.endereco;

import persistencia.EnderecoDAO;

public class TestaEnderecoDAOexclui {

    public static void main(String[] args) throws Exception {
        
        // int(id)
        System.out.println(EnderecoDAO.exclui(5));
        
    }
    
}
