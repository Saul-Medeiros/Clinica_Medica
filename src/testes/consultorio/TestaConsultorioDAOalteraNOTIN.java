package testes.consultorio;

import persistencia.ConsultorioDAO;

public class TestaConsultorioDAOalteraNOTIN {

    public static void main(String[] args) throws Exception {
        
        // int(enderecoID)[SET action], 
        // int(numero), int(numero)[WHERE actions]
        System.out.println(ConsultorioDAO.altera(1, 35, 40));
        
    }
    
}
