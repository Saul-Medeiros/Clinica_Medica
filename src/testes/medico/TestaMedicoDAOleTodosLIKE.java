package testes.medico;

import persistencia.MedicoDAO;

public class TestaMedicoDAOleTodosLIKE {

    public static void main(String[] args) throws Exception {
        
        // char
        System.out.println(MedicoDAO.leTodos('.'));
        
    }
    
}
