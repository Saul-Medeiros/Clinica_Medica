package testes.endereco;

import modelo.Endereco;
import persistencia.EnderecoDAO;

public class TestaEnderecoDAOaltera {

    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        System.out.println(alteraAnd());
    }

    /* Os métodos abaixo fazem testes em métodos sobrecarregados do pacote de persistência */

    static String alteraAnd() throws Exception {
        Endereco endereco = new Endereco();
        endereco.setRua("Plano Piloto");
        endereco.setCep(881); // 3 or 4 digits
        
        return EnderecoDAO.altera(endereco, 5, "Ceilandia");
        
    }

    static String alteraEquals() throws Exception {
        Endereco endereco = new Endereco();
        endereco.setRua("Plano Piloto");
        endereco.setCep(870);
        
        return EnderecoDAO.altera(endereco, 5);
    }
    
    static String alteraNotIn() throws Exception {
        return EnderecoDAO.altera("Plano Piloto", 882, 1, 3);
    }
    
}
