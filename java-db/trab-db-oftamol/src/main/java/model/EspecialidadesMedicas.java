package model;

import java.sql.Date;

public class EspecialidadesMedicas {
    String observacao;
    Date dt_conclusao;
    Integer id_especialidade;
    Integer id_medico;

    public EspecialidadesMedicas(String observacao, Date dt_conclusao, Integer id_especialidade, Integer id_medico) {
        this.observacao = observacao;
        this.dt_conclusao = dt_conclusao;
        this.id_especialidade = id_especialidade;
        this.id_medico = id_medico;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDt_conclusao() {
        return dt_conclusao;
    }

    public void setDt_conclusao(Date dt_conclusao) {
        this.dt_conclusao = dt_conclusao;
    }

    public Integer getId_especialidade() {
        return id_especialidade;
    }

    public void setId_especialidade(Integer id_especialidade) {
        this.id_especialidade = id_especialidade;
    }

    public Integer getId_medico() {
        return id_medico;
    }

    public void setId_medico(Integer id_medico) {
        this.id_medico = id_medico;
    }
}
