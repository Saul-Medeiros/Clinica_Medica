package testes.endereco;

import persistencia.EnderecoDAO;

public class TestaEnderecoDAOleTodosNOTBETWEEN {

    public static void main(String[] args) throws Exception {
        
        // short(id), int(id)
        System.out.println(EnderecoDAO.leTodos((short)1, 3));
        
    }
    
}
