package modelo;

public class TestaConsulta {

    public static void main(String[] args) {

        Endereco[] endereco = new Endereco[4];
        endereco[0] = new Endereco(1, "Santa Maria", 255);
        endereco[1] = new Endereco(2, "Riacho Fundo 2", 898);
        endereco[2] = new Endereco(3, "Gama Oeste", 2051);
        endereco[3] = new Endereco(4, "Taguatinga Sul", 872);

        Atendente atendente = new Atendente("João", endereco[0], 567, "Ensino médio");

        Paciente paciente = new Paciente("Saul", endereco[1], "11111111111", "61940028922");
        
        Consultorio consultorio = new Consultorio(25,endereco[3]);

        Medico medico = new Medico("Glauder", endereco[2], "12345678", "Endocrinologista", consultorio);

        Consulta consulta = new Consulta(1, "2023-06-26", "15:00", atendente, paciente, medico);
        
        System.out.println(consulta);
        
    }
    
}
