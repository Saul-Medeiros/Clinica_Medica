package testes.consulta;

import persistencia.ConsultaDAO;

public class TestaConsultaDAOleTodosNOTBETWEEN {

    public static void main(String[] args) throws Exception {
        
        // short(numeroMenor), int(numeroMaior)
        System.out.println(ConsultaDAO.leTodos((short)1, 3));
        
    }
    
}
