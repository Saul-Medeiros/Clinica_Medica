package testes.consultorio;

import modelo.Consultorio;
import modelo.Endereco;
import persistencia.ConsultorioDAO;

public class TestaConsultorioDAOalteraAND {

    public static void main(String[] args) throws Exception {
        
        /* --- WHERE actions --- */
        Consultorio consultorio = new Consultorio();
        consultorio.setNumero(0);
        
        Endereco endereco = new Endereco();
        endereco.setId(0); // id para consulta
        
        consultorio.setEndereco(endereco);
        /* --------------------- */
        
        // int[SET action], Object
        System.out.println(ConsultorioDAO.altera(0, consultorio));
        
    }
    
}
