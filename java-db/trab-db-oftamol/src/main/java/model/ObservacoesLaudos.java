package model;

public class ObservacoesLaudos {
    String descricao;
    Integer id_receita_oculos;

    public ObservacoesLaudos(String descricao, Integer id_receita_oculos) {
        this.descricao = descricao;
        this.id_receita_oculos = id_receita_oculos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getId_receita_oculos() {
        return id_receita_oculos;
    }

    public void setId_receita_oculos(Integer id_receita_oculos) {
        this.id_receita_oculos = id_receita_oculos;
    }
}
