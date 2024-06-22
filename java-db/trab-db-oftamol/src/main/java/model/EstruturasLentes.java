package model;

public class EstruturasLentes {
    String tipo_correcao;
    Integer distancia_pupilar;
    Integer id_receita_oculos;

    public EstruturasLentes(String tipo_correcao, Integer distancia_pupilar, Integer id_receita_oculos) {
        this.tipo_correcao = tipo_correcao;
        this.distancia_pupilar = distancia_pupilar;
        this.id_receita_oculos = id_receita_oculos;
    }

    public String getTipo_correcao() {
        return tipo_correcao;
    }

    public void setTipo_correcao(String tipo_correcao) {
        this.tipo_correcao = tipo_correcao;
    }

    public Integer getDistancia_pupilar() {
        return distancia_pupilar;
    }

    public void setDistancia_pupilar(Integer distancia_pupilar) {
        this.distancia_pupilar = distancia_pupilar;
    }

    public Integer getId_receita_oculos() {
        return id_receita_oculos;
    }

    public void setId_receita_oculos(Integer id_receita_oculos) {
        this.id_receita_oculos = id_receita_oculos;
    }
}
