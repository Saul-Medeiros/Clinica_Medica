package testes.consultorio;

import persistencia.ConsultorioDAO;

public class TestaConsultorioDAOleTodosIN {

    public static void main(String[] args) throws Exception {
        
        // int(numero), int(numero)
        System.out.println(ConsultorioDAO.leTodos(35, 40));
        
    }
    
}
