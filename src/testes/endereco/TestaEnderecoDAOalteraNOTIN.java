package testes.endereco;

import persistencia.EnderecoDAO;

public class TestaEnderecoDAOalteraNOTIN {

    public static void main(String[] args) throws Exception {
        
        // String, int [SET actions]
        // int, int [WHERE actions]
        System.out.println(EnderecoDAO.altera("", 0, 0, 0));
        
    }
    
}
