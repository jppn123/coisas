package model;

import java.sql.Date;

public class ReceitasOculos {
    String detalhamento;
    Date dt_consulta;
    Integer id_consulta_medica;

    public ReceitasOculos(String detalhamento, Date dt_consulta, Integer id_consulta_medica) {
        this.detalhamento = detalhamento;
        this.dt_consulta = dt_consulta;
        this.id_consulta_medica = id_consulta_medica;
    }

    public String getDetalhamento() {
        return detalhamento;
    }

    public void setDetalhamento(String detalhamento) {
        this.detalhamento = detalhamento;
    }

    public Date getDt_consulta() {
        return dt_consulta;
    }

    public void setDt_consulta(Date dt_consulta) {
        this.dt_consulta = dt_consulta;
    }

    public Integer getId_consulta_medica() {
        return id_consulta_medica;
    }

    public void setId_consulta_medica(Integer id_consulta_medica) {
        this.id_consulta_medica = id_consulta_medica;
    }
}
