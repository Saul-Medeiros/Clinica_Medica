package testes.atendente;

import modelo.Atendente;
import modelo.Endereco;
import persistencia.AtendenteDAO;

public class TestaAtendenteDAOalteraNOTIN {

    public static void main(String[] args) throws Exception {
        
        Atendente atendente = new Atendente();
        atendente.setNome("");
        atendente.setFormacao("");
        
        Endereco endereco = new Endereco();
        endereco.setId(0);
        
        atendente.setEndereco(endereco);
        
        // Object, int, int
        System.out.println(AtendenteDAO.altera(atendente, 0, 0));
        
    }
    
}
