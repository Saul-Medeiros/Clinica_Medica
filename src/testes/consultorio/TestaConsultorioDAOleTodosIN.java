package testes.consultorio;

import persistencia.ConsultorioDAO;

public class TestaConsultorioDAOleTodosIN {

    public static void main(String[] args) throws Exception {
        
        // int, int
        System.out.println(ConsultorioDAO.leTodos(0, 0));
        
    }
    
}
