package testes.endereco;

import modelo.Endereco;
import persistencia.EnderecoDAO;

public class TestaEnderecoDAOalteraEQUALS {
    
    public static void main(String[] args) throws Exception {
        
        Endereco endereco = new Endereco();
        endereco.setRua("");
        endereco.setNumero(0);
        
        // Object, int
        System.out.println(EnderecoDAO.altera(endereco, 0));
        
    }
    
}
