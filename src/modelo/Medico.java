package modelo;

public final class Medico extends Pessoa {
    
    private String crm;
    private String especialidade;
    private Consultorio consultorio;

    public Medico() {}

    public Medico(String nome, Endereco endereco, String crm,
                  String especialidade, Consultorio consultorio) {
        super(nome, endereco);
        this.crm = crm;
        this.especialidade = especialidade;
        this.consultorio = consultorio;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }

    @Override
    public String toString() {
        return "\n ------ Dados do Médico ------" +
                "\n CRM: " + getCrm() +
                "\n Nome: " + getNome() + 
                "\n Especialidade: " + getEspecialidade() +
                getEndereco() +
                getConsultorio();
    }
    
}
