package testes.consultorio;

import persistencia.ConsultorioDAO;

public class TestaConsultorioDAOleTodosLIKE {

    public static void main(String[] args) throws Exception {
        
        // char
        System.out.println(ConsultorioDAO.leTodos('.'));
        
    }
    
}
