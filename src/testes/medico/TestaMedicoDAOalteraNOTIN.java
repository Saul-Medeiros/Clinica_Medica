package testes.medico;

import modelo.Consultorio;
import modelo.Endereco;
import modelo.Medico;
import persistencia.MedicoDAO;

public class TestaMedicoDAOalteraNOTIN {

    public static void main(String[] args) throws Exception {
        
        Medico medico = new Medico();
        medico.setNome("");
        medico.setEspecialidade("");
        
        Endereco endereco = new Endereco();
        endereco.setId(0);
        Consultorio consultorio = new Consultorio();
        consultorio.setNumero(0);
        
        medico.setEndereco(endereco);
        medico.setConsultorio(consultorio);
        
        // Object[SET actions]
        // String, String [WHERE actions]
        System.out.println(MedicoDAO.altera(medico, "", ""));
        
    }
    
}
