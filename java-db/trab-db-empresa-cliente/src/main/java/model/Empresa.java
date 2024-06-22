package model;

public class Empresa {
    String nome;
    String cnpj;
    String slogan;
    Integer idEndereco;

    public Empresa(String nome, String cnpj, String slogan, Integer idEndereco) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.slogan = slogan;
        this.idEndereco = idEndereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }
}
