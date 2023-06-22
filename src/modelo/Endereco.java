package modelo;

public class Endereco {

    private int id;
    private String rua;
    private int cep;

    public Endereco() {}

    public Endereco(int id, String rua, int numero) {
        this.id = id;
        this.rua = rua;
        this.cep = numero;
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

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "\n --- Endereço ---" +
                "\n ID: " + getId() +
                "\n Rua: " + getRua() +
                "\n CEP: " + getCep() + "\n";
    }
    
}
