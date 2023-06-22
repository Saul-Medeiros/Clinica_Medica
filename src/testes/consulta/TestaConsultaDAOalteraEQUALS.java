package testes.consulta;

import modelo.Atendente;
import modelo.Consulta;
import modelo.Medico;
import modelo.Paciente;
import persistencia.ConsultaDAO;

public class TestaConsultaDAOalteraEQUALS {
    
    public static void main(String[] args) throws Exception {
        
        Consulta consulta = new Consulta();
        
        consulta.setData("07/02/2023"); // padrão: yy-MM-dd ou dd/MM/yy
        consulta.setHorario("21:00"); // padrão: hh:mm ou hh:mm:ss
        
        Atendente atendente = new Atendente();
        atendente.setMatricula(555); // padrão: 3 dígitos
        
        Paciente paciente = new Paciente();
        paciente.setCpf("22222222222"); // padrão: 11 dígitos
        
        Medico medico = new Medico();
        medico.setCrm("44444444"); // padrão: 8 dígitos
        
        consulta.setAtendente(atendente);
        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
        
        // Object, int
        System.out.println(ConsultaDAO.altera(consulta, 5));
        
    }
    
}
