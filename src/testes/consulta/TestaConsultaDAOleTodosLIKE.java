package testes.consulta;

import persistencia.ConsultaDAO;

public class TestaConsultaDAOleTodosLIKE {

    public static void main(String[] args) throws Exception {
        
        // char(primeira letra do nome do médico)
        System.out.println(ConsultaDAO.leTodos('G'));
        
    }
    
}
