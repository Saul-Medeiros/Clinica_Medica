package testes.endereco;

import persistencia.EnderecoDAO;

public class TestaEnderecoDAOleTodosLIKE {

    public static void main(String[] args) throws Exception {
        
        System.out.println(EnderecoDAO.leTodos('.'));
        
    }
    
}
