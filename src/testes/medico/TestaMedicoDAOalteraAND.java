package testes.medico;

import modelo.*;
import persistencia.MedicoDAO;

public class TestaMedicoDAOalteraAND {

    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        System.out.println(alteraAnd());
        
    }

    /* Os métodos abaixo fazem testes em métodos sobrecarregados do pacote de persistência */

    static String alteraAnd() throws Exception {
        Medico medico = new Medico();
        medico.setNome("Bárbara");
        medico.setEspecialidade("Radiologia");
        
        Endereco endereco = new Endereco();
        endereco.setId(1);
        Consultorio consultorio = new Consultorio();
        consultorio.setNumero(40);
        
        medico.setEndereco(endereco);
        medico.setConsultorio(consultorio);
        
        return MedicoDAO.altera(medico, 33333333L, "Hugo");
    }

    static String alteraEquals() throws Exception {
        Medico medico = new Medico();
        medico.setNome("Bárbara");
        medico.setEspecialidade("Radiologia");
        
        Endereco endereco = new Endereco();
        endereco.setId(1);
        Consultorio consultorio = new Consultorio();
        consultorio.setNumero(40);
        
        medico.setEndereco(endereco);
        medico.setConsultorio(consultorio);
        
        return MedicoDAO.altera(medico, "33333333");
    }

    static String alteraNotIn() throws Exception {
        Medico medico = new Medico();
        medico.setNome("Bárbara");
        medico.setEspecialidade("Radiologia");
        
        Endereco endereco = new Endereco();
        endereco.setId(1);
        Consultorio consultorio = new Consultorio();
        consultorio.setNumero(40);
        
        medico.setEndereco(endereco);
        medico.setConsultorio(consultorio);
        
        return MedicoDAO.altera(medico, "11111111", "33333333");
    }
    
}
