package testes.consultorio;

import persistencia.ConsultorioDAO;

public class TestaConsultorioDAOleTodosNOTBETWEEN {

    public static void main(String[] args) throws Exception {
        
        // short(numero), int(numero)
        System.out.println(ConsultorioDAO.leTodos((short)30, 40));
        
    }
    
}
