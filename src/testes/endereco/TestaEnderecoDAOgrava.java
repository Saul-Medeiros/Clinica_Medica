package testes.endereco;

import modelo.Endereco;
import persistencia.EnderecoDAO;

public class TestaEnderecoDAOgrava {

    public static void main(String[] args) throws Exception {
        
        Endereco endereco = new Endereco();
        endereco.setId(0);
        endereco.setRua("");
        endereco.setNumero(0);
        
        System.out.println(EnderecoDAO.grava(endereco));
        
    }
    
}
