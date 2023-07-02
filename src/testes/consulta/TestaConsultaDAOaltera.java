package testes.consulta;

import modelo.*;
import persistencia.ConsultaDAO;

public class TestaConsultaDAOaltera {

    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        System.out.println(alteraAnd());
        
    }

    /* Os métodos abaixo fazem testes em métodos sobrecarregados do pacote de persistência */

    static String alteraAnd() throws Exception {
        Consulta consulta = new Consulta();
        
        consulta.setData("07/02/2023"); // yy-MM-dd or dd/MM/yy
        
        Atendente atendente = new Atendente();
        atendente.setMatricula(111);
        
        Paciente paciente = new Paciente();
        paciente.setCpf("11111111111"); // 11 digits
        
        Medico medico = new Medico();
        medico.setCrm("11111111"); // 8 digits
        
        consulta.setAtendente(atendente);
        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
        
        return ConsultaDAO.altera(consulta, 5, "09:00");
    }
    
    static String alteraEquals() throws Exception {
        Consulta consulta = new Consulta();
        
        consulta.setData("07/02/2023");
        consulta.setHorario("21:00");
        
        Atendente atendente = new Atendente();
        atendente.setMatricula(555);
        
        Paciente paciente = new Paciente();
        paciente.setCpf("22222222222");
        
        Medico medico = new Medico();
        medico.setCrm("44444444");
        
        consulta.setAtendente(atendente);
        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
        
        return ConsultaDAO.altera(consulta, 5);
    }

    static String alteraNotIn() throws Exception {
        Consulta consulta = new Consulta();
        
        consulta.setData("");
        consulta.setHorario("");
        
        Atendente atendente = new Atendente();
        atendente.setMatricula(333);
        
        Paciente paciente = new Paciente();
        paciente.setCpf("11111111111");
        
        Medico medico = new Medico();
        medico.setCrm("22222222");
        
        consulta.setAtendente(atendente);
        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
        
        return ConsultaDAO.altera(consulta, 1, 5);
    }

}
