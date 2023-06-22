package testes.consulta;

import modelo.Atendente;
import modelo.Consulta;
import modelo.Medico;
import modelo.Paciente;
import persistencia.ConsultaDAO;

public class TestaConsultaDAOalteraNOTIN {

    public static void main(String[] args) throws Exception {
        
        Consulta consulta = new Consulta();
        
        consulta.setData(""); // padrão: yy-MM-dd ou dd/MM/yy
        consulta.setHorario(""); // padrão: hh:mm ou hh:mm:ss
        
        Atendente atendente = new Atendente();
        atendente.setMatricula(333); // padrão: 3 dígitos
        
        Paciente paciente = new Paciente();
        paciente.setCpf("11111111111"); // padrão: 11 dígitos
        
        Medico medico = new Medico();
        medico.setCrm("22222222"); // padrão: 8 dígitos
        
        consulta.setAtendente(atendente);
        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
        
        // Object[SET actions],
        // int(menorNumero), int(maiorNumero) [WHERE actions]
        System.out.println(ConsultaDAO.altera(consulta, 1, 5));
        
    }
    
}
