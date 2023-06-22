package testes.atendente;

import modelo.Atendente;
import modelo.Endereco;
import persistencia.AtendenteDAO;

public class TestaAtendenteDAOalteraNOTIN {

    public static void main(String[] args) throws Exception {
        
        Atendente atendente = new Atendente();
        atendente.setNome("José");
        atendente.setFormacao("Ensino Superior");
        
        Endereco endereco = new Endereco();
        endereco.setId(4);
        
        atendente.setEndereco(endereco);
        
        // Object [SET actions],
        // int(menorMatricula), int(maiorMatricula) [WHERE actions]
        System.out.println(AtendenteDAO.altera(atendente, 333, 555));
        
    }
    
}
