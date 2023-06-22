package testes.medico;

import modelo.Consultorio;
import modelo.Endereco;
import modelo.Medico;
import persistencia.MedicoDAO;

public class TestaMedicoDAOalteraEQUALS {
    
    public static void main(String[] args) throws Exception {
        
        Medico medico = new Medico();
        medico.setNome("Bárbara");
        medico.setEspecialidade("Radiologia");
        
        Endereco endereco = new Endereco();
        endereco.setId(1);
        Consultorio consultorio = new Consultorio();
        consultorio.setNumero(40);
        
        medico.setEndereco(endereco);
        medico.setConsultorio(consultorio);
        
        // Object[SET actions], String(crm)[WHERE actions]
        System.out.println(MedicoDAO.altera(medico, "33333333"));
        
    }
    
}
