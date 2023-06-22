package testes.consulta;

import persistencia.ConsultaDAO;

public class TestaConsultaDAOleTodosIN {

    public static void main(String[] args) throws Exception {
        
        // int, int
        System.out.println(ConsultaDAO.leTodos(1, 3));
        
    }
    
}
