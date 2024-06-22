package model;

public class AtributosEstruturaLente {
    String descricao;
    String lado_olho;

    public AtributosEstruturaLente(String descricao, String lado_olho) {
        this.descricao = descricao;
        this.lado_olho = lado_olho;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLado_olho() {
        return lado_olho;
    }

    public void setLado_olho(String lado_olho) {
        this.lado_olho = lado_olho;
    }
}
