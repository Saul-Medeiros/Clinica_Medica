package testes.consultorio;

import persistencia.ConsultorioDAO;

public class TestaConsultorioDAOleTodosLIKE {

    public static void main(String[] args) throws Exception {
        
        // char(primeira letra da rua do Consultorio)
        System.out.println(ConsultorioDAO.leTodos('C'));
        
    }
    
}
