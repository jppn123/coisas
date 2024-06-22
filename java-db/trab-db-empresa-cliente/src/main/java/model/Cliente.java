package model;

import java.sql.Date;

public class Cliente {
    String nome;
    Date dt_nascimento;
    String cpf;
    String email;
    Integer id_endereco;

    public Cliente(String nome, Date dt_nascimento, String cpf, String email, Integer id_endereco) {
        this.nome = nome;
        this.dt_nascimento = dt_nascimento;
        this.cpf = cpf;
        this.email = email;
        this.id_endereco = id_endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(Date dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(Integer id_endereco) {
        this.id_endereco = id_endereco;
    }
}
