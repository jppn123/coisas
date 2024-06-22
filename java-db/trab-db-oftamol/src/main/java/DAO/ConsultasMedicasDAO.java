package DAO;

import model.ConsultasMedicas;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultasMedicasDAO extends ConexaoDB {

    private static final String INSERT_SQL = "INSERT INTO consultas_medicas (assinatura, dt_consulta, id_paciente, id_medico) VALUES (?, ?, ?, ?);";
    private static final String SELECT_BY_ID = "SELECT * FROM consultas_medicas WHERE id = ?";
    private static final String SELECT_ALL = "SELECT * FROM consultas_medicas;";
    private static final String DELETE_SQL = "DELETE FROM consultas_medicas WHERE id = ?;";
    private static final String UPDATE_SQL = "UPDATE consultas_medicas SET assinatura = ?, dt_consulta = ?, id_paciente = ?, id_medico = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM consultas_medicas;";

    public Integer count() {
        Integer count = 0;
        try (PreparedStatement preparedStatement = prepararSQL(TOTAL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return count;
    }
    public void insertConsultasMedicas(ConsultasMedicas entidade){
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_SQL)) {
            preparedStatement.setString(1, entidade.getAssinatura());
            preparedStatement.setDate(2, entidade.getDt_consulta());
            preparedStatement.setInt(3, entidade.getId_paciente());
            preparedStatement.setInt(4, entidade.getId_medico());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("O id da uf inserido não existe!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ConsultasMedicas selectConsultasMedicas(int id) {
        ConsultasMedicas entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String assinatura = rs.getString("assinatura");
                Date dt_consulta = rs.getDate("dt_consulta");
                Integer id_paciente = rs.getInt("id_paciente");
                Integer id_medico = rs.getInt("id_medico");
                entidade = new ConsultasMedicas(assinatura, dt_consulta, id_paciente, id_medico);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NullPointerException e){
            System.out.println("O id informado não existe!");
        }
        return entidade;
    }
    public List<ConsultasMedicas> selectAllConsultasMedicas() {

        List<ConsultasMedicas> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String assinatura = rs.getString("assinatura");
                Date dt_consulta = rs.getDate("dt_consulta");
                Integer id_paciente = rs.getInt("id_paciente");
                Integer id_medico = rs.getInt("id_medico");
                entidades.add(new ConsultasMedicas(assinatura, dt_consulta, id_paciente, id_medico));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteConsultasMedicas(int id){
        try (PreparedStatement statement = prepararSQL(DELETE_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e){
            System.out.println("Id inserido não existente!");
        }
        return false;
    }

    public boolean updateConsultasMedicas(ConsultasMedicas entidade, int id) {
        try (PreparedStatement preparedStatement = prepararSQL(UPDATE_SQL)) {
            preparedStatement.setString(1, entidade.getAssinatura());
            preparedStatement.setDate(2, entidade.getDt_consulta());
            preparedStatement.setInt(3, entidade.getId_paciente());
            preparedStatement.setInt(4, entidade.getId_medico());
            preparedStatement.setInt(5, id);

            return preparedStatement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}