package testes.consultorio;

import modelo.Consultorio;
import modelo.Endereco;
import persistencia.ConsultorioDAO;

public class TestaConsultorioDAOalteraAND {

    public static void main(String[] args) throws Exception {
        
        /* --- WHERE actions --- */
        Consultorio consultorio = new Consultorio();
        consultorio.setNumero(40); // padrão: 2 dígitos
        
        Endereco endereco = new Endereco();
        endereco.setId(5); // padrão: 1 dígito
        
        consultorio.setEndereco(endereco);
        /* --------------------- */
        
        // int(enderecoId)[SET action], Object
        System.out.println(ConsultorioDAO.altera(3, consultorio));
        
    }
    
}
