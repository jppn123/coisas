package model;

public class Cidade {
    private String descricao;
    private Integer codigo;
    private Integer id_uf;

    public Cidade(String descricao, Integer codigo, Integer id_uf) {
        this.descricao = descricao;
        this.codigo = codigo;
        this.id_uf = id_uf;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getId_uf() {
        return id_uf;
    }

    public void setId_uf(Integer id_uf) {
        this.id_uf = id_uf;
    }
}
