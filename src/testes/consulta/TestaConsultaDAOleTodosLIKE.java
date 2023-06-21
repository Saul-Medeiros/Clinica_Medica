package testes.consulta;

import persistencia.ConsultaDAO;

public class TestaConsultaDAOleTodosLIKE {

    public static void main(String[] args) throws Exception {
        
        // char
        System.out.println(ConsultaDAO.leTodos('.'));
        
    }
    
}
