package testes.consultorio;

import persistencia.ConsultorioDAO;

public class TestaConsultorioDAOalteraEQUALS {
    
    public static void main(String[] args) throws Exception {
        
        // int(enderecoID)[SET action], int(numero)[WHERE action]
        System.out.println(ConsultorioDAO.altera(0, 0));
        
    }
    
}
