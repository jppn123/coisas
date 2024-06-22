package model;

public class EspecificacoesLente {
    Double valor;
    Integer id_estrutura_lente;
    Integer id_atributo_estrutura_lente;

    public EspecificacoesLente(Double valor, Integer id_estrutura_lente, Integer id_atributo_estrutura_lente) {
        this.valor = valor;
        this.id_estrutura_lente = id_estrutura_lente;
        this.id_atributo_estrutura_lente = id_atributo_estrutura_lente;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getId_estrutura_lente() {
        return id_estrutura_lente;
    }

    public void setId_estrutura_lente(Integer id_estrutura_lente) {
        this.id_estrutura_lente = id_estrutura_lente;
    }

    public Integer getId_atributo_estrutura_lente() {
        return id_atributo_estrutura_lente;
    }

    public void setId_atributo_estrutura_lente(Integer id_atributo_estrutura_lente) {
        this.id_atributo_estrutura_lente = id_atributo_estrutura_lente;
    }
}
