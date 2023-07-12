package modelo;

public class Consulta {

    private int numero;
    private String data;
    private String horario;
    private Atendente atendente;
    private Paciente paciente;
    private Medico medico;

    public Consulta() {}

    public Consulta(int numero, String data, String horario, 
                    Atendente atendente, Paciente paciente, Medico medico) {
        this.numero = numero;
        this.data = data;
        this.horario = horario;
        this.atendente = atendente;
        this.paciente = paciente;
        this.medico = medico;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Método modificado para retornar a data apenas no padrão dd/MM/yy.
     * (converte dos padrões do mysql)
     * 
     * @return data = (dd/MM/yy)
     */
    public String getData() {
        if (data.contains("/")) {
            return data;
        }
        
        String[] dataSplit = data.split("-");
        String newData = dataSplit[2] + "/" + dataSplit[1] + "/" + dataSplit[0];
        return newData;
    }
    
    /**
     * Conversão de data para os padrões do mysql -> yy-MM-dd
     * (isso permite inserir informações de data no formato dd/MM/yy no Java)
     * 
     *  @return data = (yy-MM-dd)
     */
    public String sqlData() {
        String[] dataSplit = getData().split("/");
        String newData = dataSplit[2] + "-" + dataSplit[1] + "-" + dataSplit[0];
        return newData;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    @Override
    public String toString() {
        return "\n ===== Dados da Consulta =====" +
                "\n Número: " + getNumero() + 
                "\n Data: " + getData() +
                "\n Horário: " + getHorario() + "\n" +
                getAtendente() + 
                getPaciente() + 
                getMedico() + 
                "\n =============================\n";
    }
    
}
