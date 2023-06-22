package testes.atendente;

import modelo.Atendente;
import modelo.Endereco;
import persistencia.AtendenteDAO;

public class TestaAtendenteDAOalteraAND {

    public static void main(String[] args) throws Exception {
        
        Atendente atendente = new Atendente();
        atendente.setNome("Adolfo");
        atendente.setFormacao("Superior em TI");
        
        Endereco endereco = new Endereco();
        endereco.setId(2);
        
        atendente.setEndereco(endereco);
        
        // Object[SET actions], int(matricula), char(letra)
        System.out.println(AtendenteDAO.altera(atendente, 555, 'R'));
        
    }
    
}
