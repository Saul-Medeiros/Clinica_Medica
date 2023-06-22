package testes.medico;

import persistencia.MedicoDAO;

public class TestaMedicoDAOleTodosLIKE {

    public static void main(String[] args) throws Exception {
        
        // char(primeira letra do nome do médico)
        System.out.println(MedicoDAO.leTodos('V'));
        
    }
    
}
