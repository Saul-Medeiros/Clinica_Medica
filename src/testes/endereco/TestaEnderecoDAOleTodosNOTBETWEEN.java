package testes.endereco;

import persistencia.EnderecoDAO;

public class TestaEnderecoDAOleTodosNOTBETWEEN {

    public static void main(String[] args) throws Exception {
        
        // short, int
        System.out.println(EnderecoDAO.leTodos((short)0, 0));
        
    }
    
}
