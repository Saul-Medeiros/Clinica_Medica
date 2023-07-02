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
        consulta.setData("13/02/2024"); // yy-MM-dd or dd/MM/yy
        consulta.setHorario("15:00"); // hh:mm or hh:mm:ss
        
        Atendente atendente = new Atendente();
        atendente.setMatricula(111); // 3 digits
        
        Paciente paciente = new Paciente();
        paciente.setCpf("33333333333"); // 11 dígits
        
        Medico medico = new Medico();
        medico.setCrm("44444444"); // 8 digits
        
        consulta.setAtendente(atendente);
        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
        
        System.out.println(ConsultaDAO.grava(consulta));
        
    }
    
}
