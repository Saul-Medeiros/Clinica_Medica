package testes.consultorio;

import persistencia.ConsultorioDAO;

public class TestaConsultorioDAOgrava {

    public static void main(String[] args) throws Exception {
        
        // int(numero), int(enderecoId)
        System.out.println(ConsultorioDAO.grava(45, 3));
        
    }
    
}
