package model;

public class Endereco {
    private String rua;
    private String bairro;
    private String numero;
    private String cep;
    private Integer idCidade;

    public Endereco(String rua, String bairro, String numero, String cep, Integer idCidade) {
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.cep = cep;
        this.idCidade = idCidade;
    }
    public Endereco(String rua, String bairro, String cep, Integer idCidade) {
        this.rua = rua;
        this.bairro = bairro;
        this.cep = cep;
        this.idCidade = idCidade;
    }
    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }
}
