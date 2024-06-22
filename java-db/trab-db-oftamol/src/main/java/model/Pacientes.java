package model;

import java.sql.Date;

public class Pacientes {
    String nome;
    String cpf;
    Date dt_nascimento;

    public Pacientes(String nome, String cpf, Date dt_nascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dt_nascimento = dt_nascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(Date dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }
}
