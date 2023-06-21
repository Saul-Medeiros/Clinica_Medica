package testes.consulta;

import modelo.Atendente;
import modelo.Consulta;
import modelo.Medico;
import modelo.Paciente;
import persistencia.ConsultaDAO;

public class TestaConsultaDAOgrava {

    public static void main(String[] args) throws Exception {
        
        Consulta consulta = new Consulta();
        
        consulta.setData(""); // padrão: yy-MM-dd ou dd/MM/yy
        consulta.setHorario(""); // padrão: hh:mm ou hh:mm:ss
        
        Atendente atendente = new Atendente();
        atendente.setMatricula(0);
        
        Paciente paciente = new Paciente();
        paciente.setCpf(""); // padrão: 11111111111
        
        Medico medico = new Medico();
        medico.setCrm(""); // padrão: 11111111
        
        consulta.setAtendente(atendente);
        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
        
        // Object
        System.out.println(ConsultaDAO.grava(consulta));
        
    }
    
}
