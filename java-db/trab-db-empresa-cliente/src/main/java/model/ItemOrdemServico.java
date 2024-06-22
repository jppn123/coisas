package model;

public class ItemOrdemServico {
    String descricao;
    Double preco;
    Integer idOrdemServico;

    public ItemOrdemServico(String descricao, Double preco, Integer idOrdemServico) {
        this.descricao = descricao;
        this.preco = preco;
        this.idOrdemServico = idOrdemServico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getIdOrdemServico() {
        return idOrdemServico;
    }

    public void setIdOrdemServico(Integer idOrdemServico) {
        this.idOrdemServico = idOrdemServico;
    }
}
