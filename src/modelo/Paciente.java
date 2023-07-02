package modelo;

import org.apache.commons.lang.StringUtils;

public final class Paciente extends Pessoa {

    private String cpf;
    private String telefone;

    public Paciente() {}

    public Paciente(String nome, Endereco endereco, String cpf, String telefone)
    {
        super(nome, endereco);
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }
    
    /**
     * Método retorna cpf formatado para impressão na tela
     * 
     * @return cpf = (000.000.000-00)
     */
    public String formataCpf() {
        String cpfCompleto = StringUtils.leftPad(getCpf(), 11, '0');
        return cpfCompleto.substring(0,3) + "." + 
                cpfCompleto.substring(3,6) + "." + 
                cpfCompleto.substring(6,9) + "-" + 
                cpfCompleto.substring(9,11);
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    /**
     * Número de telefone formatado para impressao na tela (é necessário 
     * inserir o número com ddd). Ex: 61900000000
     * 
     * @return telefone = (00) 00000-0000
     */
    public String formataTelefone() {
        return "(" + getTelefone().substring(0,2) + ") " + 
                getTelefone().substring(2,7) +
                "-" + getTelefone().substring(7,11);
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
        
    @Override
    public String toString() {
        return "\n ----- Dados do Paciente -----" + 
                "\n CPF: " + formataCpf() + 
                "\n Telefone: " + formataTelefone() +
                "\n Nome: " + getNome() +
                getEndereco();
    }
    
}
