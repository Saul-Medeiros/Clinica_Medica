package modelo;

public class TestaConsulta {

    public static void main(String[] args) {
        
        Consulta c = new Consulta(1, "2023-06-26", "15:00",
            new Atendente("João",
                new Endereco(1, "Santa Maria", 255),
                567, "Ensino médio"
            ),
            new Paciente("Saul",
                new Endereco(2, "Riacho Fundo 2", 898),
                "11111111111", "61940028922"
            ),
            new Medico("Glauder",
                new Endereco(3, "Gama Oeste", 2051),
                "12345678", "Endocrinologista",
                new Consultorio(25,
                    new Endereco(4, "Taguatinga Sul", 872)
                )
            )
        );
        
        System.out.println(c);
        
    }
    
}
