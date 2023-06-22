package testes.atendente;

import persistencia.AtendenteDAO;

public class TestaAtendenteDAOalteraEQUALS {
    
    public static void main(String[] args) throws Exception {
        
        // String(nome), String(formacao), int(enderecoId), int(matricula)
        System.out.println(AtendenteDAO.altera(
                "José", "Ensino Fundamental", 4, 555));
        
    }
    
}
