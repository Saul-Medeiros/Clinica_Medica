package testes.consulta;

import modelo.Atendente;
import modelo.Consulta;
import modelo.Medico;
import modelo.Paciente;
import persistencia.ConsultaDAO;

public class TestaConsultaDAOalteraAND {

    public static void main(String[] args) throws Exception {
        
        Consulta consulta = new Consulta();
        
        consulta.setData("07/02/2023"); // padrão: yy-MM-dd ou dd/MM/yy
        consulta.setHorario("21:00"); // padrão: hh:mm ou hh:mm:ss
        
        Atendente atendente = new Atendente();
        atendente.setMatricula(111); // 3 dígitos
        
        Paciente paciente = new Paciente();
        paciente.setCpf("11111111111"); // padrão: 11 dígitos
        
        Medico medico = new Medico();
        medico.setCrm("11111111"); // padrão: 8 dígitos
        
        consulta.setAtendente(atendente);
        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
        
        
        // Object[SET actions],
        // int(número), String(hh:mm) [WHERE actions]
        System.out.println(ConsultaDAO.altera(consulta, 5, "09:00"));
        
    }
    
}
