package testes.endereco;

import persistencia.EnderecoDAO;

public class TestaEnderecoDAOalteraNOTIN {

    public static void main(String[] args) throws Exception {
        
        // String(rua), int(cep) [SET actions]
        // int(id), int(id) [WHERE actions]
        System.out.println(EnderecoDAO.altera("Plano Piloto", 882, 1, 3));
        
    }
    
}
