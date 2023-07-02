package testes.consulta;

import persistencia.ConsultaDAO;

public class TestaConsultaDAOleUm {

    public static void main(String[] args) throws Exception {
        
        System.out.println(ConsultaDAO.leUm(1));
        
    }
    
}
