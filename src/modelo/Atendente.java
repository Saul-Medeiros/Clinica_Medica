package modelo;

public final class Atendente extends Pessoa {
    
    private int matricula;
    private String formacao;

    public Atendente() {}

    public Atendente(String nome, Endereco endereco, int matricula, 
                     String formacao) {
        super(nome, endereco);
        this.matricula = matricula;
        this.formacao = formacao;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    @Override
    public String toString() {
        return "\n ---- Dados do Atendente -----" +
                "\n Matrícula: " + getMatricula() + 
                "\n Formação: " + getFormacao() + 
                "\n Nome: " + getNome() + 
                getEndereco();
    }
    
}
