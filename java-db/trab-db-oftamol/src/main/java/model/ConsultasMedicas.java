package model;

import java.sql.Date;

public class ConsultasMedicas {
    String assinatura;
    Date dt_consulta;
    Integer id_paciente;
    Integer id_medico;

    public ConsultasMedicas(String assinatura, Date dt_consulta, Integer id_paciente, Integer id_medico) {
        this.assinatura = assinatura;
        this.dt_consulta = dt_consulta;
        this.id_paciente = id_paciente;
        this.id_medico = id_medico;
    }

    public String getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(String assinatura) {
        this.assinatura = assinatura;
    }

    public Date getDt_consulta() {
        return dt_consulta;
    }

    public void setDt_consulta(Date dt_consulta) {
        this.dt_consulta = dt_consulta;
    }

    public Integer getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(Integer id_paciente) {
        this.id_paciente = id_paciente;
    }

    public Integer getId_medico() {
        return id_medico;
    }

    public void setId_medico(Integer id_medico) {
        this.id_medico = id_medico;
    }
}
