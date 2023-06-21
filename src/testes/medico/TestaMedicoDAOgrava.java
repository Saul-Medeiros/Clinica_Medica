package testes.medico;

import modelo.Consultorio;
import modelo.Endereco;
import modelo.Medico;
import persistencia.MedicoDAO;

public class TestaMedicoDAOgrava {

    public static void main(String[] args) throws Exception {
        
        Medico medico = new Medico();
        medico.setCrm("");
        medico.setNome("");
        medico.setEspecialidade("");
        
        Endereco endereco = new Endereco();
        endereco.setId(0);
        Consultorio consultorio = new Consultorio();
        consultorio.setNumero(0);
        
        medico.setEndereco(endereco);
        medico.setConsultorio(consultorio);
        
        // Object[INSERT action]
        System.out.println(MedicoDAO.grava(medico));
        
    }
    
}
