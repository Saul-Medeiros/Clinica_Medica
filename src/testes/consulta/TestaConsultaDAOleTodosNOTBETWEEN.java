package testes.consulta;

import persistencia.ConsultaDAO;

public class TestaConsultaDAOleTodosNOTBETWEEN {

    public static void main(String[] args) throws Exception {
        
        // short, int
        System.out.println(ConsultaDAO.leTodos((short)0, 0));
        
    }
    
}
