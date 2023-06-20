package modelo;

public class Endereco {

    private int id;
    private String rua;
    private int numero;

    public Endereco() {}

    public Endereco(int id, String rua, int numero) {
        this.id = id;
        this.rua = rua;
        this.numero = numero;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "\n --- Endereço ---" +
                "\n ID: " + getId() +
                "\n Rua: " + getRua() +
                "\n Número: " + getNumero() + "\n";
    }
    
}
