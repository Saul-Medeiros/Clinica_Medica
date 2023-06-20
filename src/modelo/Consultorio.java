package modelo;

public class Consultorio {

    private int numero;
    private Endereco endereco;

    public Consultorio() {}

    public Consultorio(int numero, Endereco endereco) {
        this.numero = numero;
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Endereco getEndereco() {
        return endereco;
    }
    
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "\n -------- Consultório --------" +
                "\n Número: " + getNumero() +
                getEndereco();
    }
}
