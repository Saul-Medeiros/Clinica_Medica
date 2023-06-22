package testes.atendente;

import modelo.Atendente;
import modelo.Endereco;
import persistencia.AtendenteDAO;

public class TestaAtendenteDAOgrava {

    public static void main(String[] args) throws Exception {
        
        Atendente atendente = new Atendente();
        atendente.setMatricula(777);
        atendente.setNome("Caio");
        atendente.setFormacao("Ensino Fundamental Incompleto");
        
        Endereco endereco = new Endereco();
        endereco.setId(5);
        
        atendente.setEndereco(endereco);
        
        // Object
        System.out.println(AtendenteDAO.grava(atendente));
        
    }
    
}
