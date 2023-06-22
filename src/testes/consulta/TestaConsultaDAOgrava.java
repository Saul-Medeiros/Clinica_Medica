package testes.consulta;

import modelo.Atendente;
import modelo.Consulta;
import modelo.Medico;
import modelo.Paciente;
import persistencia.ConsultaDAO;

public class TestaConsultaDAOgrava {

    public static void main(String[] args) throws Exception {
        
        Consulta consulta = new Consulta();
        consulta.setNumero(6);
        consulta.setData("13/02/2024"); // padrão: yy-MM-dd ou dd/MM/yy
        consulta.setHorario("15:00"); // padrão: hh:mm ou hh:mm:ss
        
        Atendente atendente = new Atendente();
        atendente.setMatricula(111); // padrão: 3 dígitos
        
        Paciente paciente = new Paciente();
        paciente.setCpf("33333333333"); // padrão: 11 dígitos
        
        Medico medico = new Medico();
        medico.setCrm("44444444"); // padrão: 8 dígitos
        
        consulta.setAtendente(atendente);
        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
        
        // Object
        System.out.println(ConsultaDAO.grava(consulta));
        
    }
    
}
