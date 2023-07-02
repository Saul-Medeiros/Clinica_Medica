package testes.consultorio;

import modelo.*;
import persistencia.ConsultorioDAO;

public class TestaConsultorioDAOaltera {

    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        System.out.println(alteraAnd());
        
    }

    /* Os métodos abaixo fazem testes em métodos sobrecarregados do pacote de persistência */

    static String alteraAnd() throws Exception {
        Consultorio consultorio = new Consultorio();
        consultorio.setNumero(40); // 2 digits
        
        Endereco endereco = new Endereco();
        endereco.setId(5); // 1 digit
        
        consultorio.setEndereco(endereco);
        
        return ConsultorioDAO.altera(3, consultorio);
    }

    static String alteraEquals() throws Exception {
        return ConsultorioDAO.altera(1, 40);
    }

    static String alteraNotIn() throws Exception {
        return ConsultorioDAO.altera(1, 35, 40);
    }
    
}
