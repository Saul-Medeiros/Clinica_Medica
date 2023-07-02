package testes.paciente;

import java.util.List;
import modelo.Paciente;
import persistencia.PacienteDAO;

public class TestaPacienteDAOleTodos {

    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        System.out.println(leTodos());
        
    }
    
    /* Os métodos abaixo fazem testes em métodos sobrecarregados do pacote de persistência */

    static List<Paciente> leTodos() throws Exception {
        return PacienteDAO.leTodos();
    }

    static List<Paciente> leTodosIn() throws Exception {
        return PacienteDAO.leTodos("11111111111", "33333333333");
    }
    
    static List<Paciente> leTodosLike() throws Exception {
        return PacienteDAO.leTodos('P');
    }
    
    static List<Paciente> leTodosNotBetween() throws Exception {
        return PacienteDAO.leTodos(11111111111L, "33333333333");
    }
}
