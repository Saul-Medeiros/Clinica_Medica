package testes.endereco;

import modelo.Endereco;
import persistencia.EnderecoDAO;

public class TestaEnderecoDAOalteraAND {

    public static void main(String[] args) throws Exception {
        
        Endereco endereco = new Endereco();
        endereco.setRua("Plano Piloto");
        endereco.setCep(881); // padrão: 3 a 4 dígitos
        
        // Object[SET action], 
        // int(id), String(rua) [WHERE actions]
        System.out.println(EnderecoDAO.altera(endereco, 5, "Ceilandia"));
        
    }
    
}
