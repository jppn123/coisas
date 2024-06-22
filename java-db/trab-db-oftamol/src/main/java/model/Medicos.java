package model;

public class Medicos {
    String nome;
    String crm;

    public Medicos(String nome, String crm) {
        this.nome = nome;
        this.crm = crm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }
}
