package testes.atendente;

import modelo.*;
import persistencia.AtendenteDAO;

public class TestaAtendenteDAOaltera {

    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        System.out.println(alteraAnd());
        
    }

    /* Os métodos abaixo fazem testes em métodos sobrecarregados do pacote de persistência */

    static String alteraAnd() throws Exception {
        Atendente atendente = new Atendente();
        atendente.setNome("Adolfo");
        atendente.setFormacao("Superior em TI");
        
        Endereco endereco = new Endereco();
        endereco.setId(2);
        
        atendente.setEndereco(endereco);
        
        return AtendenteDAO.altera(atendente, 555, 'R');
    }

    static String alteraEquals() throws Exception {
        return AtendenteDAO.altera("José", "Ensino Fundamental", 4, 555);
    }

    static String alteraNotIn() throws Exception {
        Atendente atendente = new Atendente();
        atendente.setNome("José");
        atendente.setFormacao("Ensino Superior");
        
        Endereco endereco = new Endereco();
        endereco.setId(4);
        
        atendente.setEndereco(endereco);
        
        return AtendenteDAO.altera(atendente, 333, 555);
    }
    
}
