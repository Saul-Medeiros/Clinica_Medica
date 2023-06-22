package testes.endereco;

import modelo.Endereco;
import persistencia.EnderecoDAO;

public class TestaEnderecoDAOgrava {

    public static void main(String[] args) throws Exception {
        
        Endereco endereco = new Endereco();
        endereco.setId(6);
        endereco.setRua("Núcleo Bandeirante");
        endereco.setCep(87);
        
        System.out.println(EnderecoDAO.grava(endereco));
        
    }
    
}
