package testes.atendente;

import modelo.Atendente;
import persistencia.AtendenteDAO;

public class TestaAtendenteDAOalteraAND {

    public static void main(String[] args) throws Exception {
        
        Atendente atendente = new Atendente();
        atendente.setNome("");
        atendente.setFormacao("");
        atendente.getEndereco().setId(0);
        
        // object, int, char
        System.out.println(AtendenteDAO.altera(atendente, 0, 'e'));
        
    }
    
}
