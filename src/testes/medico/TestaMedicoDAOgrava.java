package testes.medico;

import modelo.*;
import persistencia.MedicoDAO;

public class TestaMedicoDAOgrava {

    public static void main(String[] args) throws Exception {
        
        Medico medico = new Medico();
        medico.setCrm("77777777"); // 8 digits
        medico.setNome("Gabriel");
        medico.setEspecialidade("Radiologista");
        
        Endereco endereco = new Endereco();
        endereco.setId(5);
        Consultorio consultorio = new Consultorio();
        consultorio.setNumero(40);
        
        medico.setEndereco(endereco);
        medico.setConsultorio(consultorio);
        
        System.out.println(MedicoDAO.grava(medico));
        
    }
    
}
