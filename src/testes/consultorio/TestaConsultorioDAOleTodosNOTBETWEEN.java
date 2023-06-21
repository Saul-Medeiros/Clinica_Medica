package testes.consultorio;

import persistencia.ConsultorioDAO;

public class TestaConsultorioDAOleTodosNOTBETWEEN {

    public static void main(String[] args) throws Exception {
        
        // short, int
        System.out.println(ConsultorioDAO.leTodos((short)0, 0));
        
    }
    
}
