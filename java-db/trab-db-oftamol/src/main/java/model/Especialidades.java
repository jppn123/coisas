package model;

public class Especialidades {
    String descricao;
    String conselho;

    public Especialidades(String descricao, String conselho) {
        this.descricao = descricao;
        this.conselho = conselho;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getConselho() {
        return conselho;
    }

    public void setConselho(String conselho) {
        this.conselho = conselho;
    }
}
