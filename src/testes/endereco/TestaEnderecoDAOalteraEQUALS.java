package testes.endereco;

import modelo.Endereco;
import persistencia.EnderecoDAO;

public class TestaEnderecoDAOalteraEQUALS {
    
    public static void main(String[] args) throws Exception {
        
        Endereco endereco = new Endereco();
        endereco.setRua("Plano Piloto");
        endereco.setCep(870); // padrão: 3 a 4 dígitos
        
        // Object[SET actions], 
        // int(id) [WHERE action]
        System.out.println(EnderecoDAO.altera(endereco, 5));
        
    }
    
}
