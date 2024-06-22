package DAO;

import model.EspecialidadesMedicas;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadesMedicasDAO extends ConexaoDB {

    private static final String INSERT_SQL = "INSERT INTO especialidades_medicas (observacao, dt_conclusao, id_especialidade, id_medico) VALUES (?, ?, ?, ?);";
    private static final String SELECT_BY_ID = "SELECT * FROM especialidades_medicas WHERE id = ?";
    private static final String SELECT_ALL = "SELECT * FROM especialidades_medicas;";
    private static final String DELETE_SQL = "DELETE FROM especialidades_medicas WHERE id = ?;";
    private static final String UPDATE_SQL = "UPDATE especialidades_medicas SET observacao = ?, dt_conclusao = ?, id_especialidade = ?, id_medico = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM especialidades_medicas;";

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
    public void insertEspecialidadesMedicas(EspecialidadesMedicas entidade){
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_SQL)) {
            preparedStatement.setString(1, entidade.getObservacao());
            preparedStatement.setDate(2, entidade.getDt_conclusao());
            preparedStatement.setInt(3, entidade.getId_especialidade());
            preparedStatement.setInt(4, entidade.getId_medico());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("O id da uf inserido não existe!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public EspecialidadesMedicas selectEspecialidadesMedicas(int id) {
        EspecialidadesMedicas entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String observacao = rs.getString("observacao");
                Date dt_conclusao = rs.getDate("dt_conclusao");
                Integer id_especialidade = rs.getInt("id_especialidade");
                Integer id_medico = rs.getInt("id_medico");
                entidade = new EspecialidadesMedicas(observacao, dt_conclusao, id_especialidade, id_medico);
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
    public List<EspecialidadesMedicas> selectAllEspecialidadesMedicas() {

        List<EspecialidadesMedicas> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String observacao = rs.getString("observacao");
                Date dt_conclusao = rs.getDate("dt_conclusao");
                Integer id_especialidade = rs.getInt("id_especialidade");
                Integer id_medico = rs.getInt("id_medico");
                entidades.add(new EspecialidadesMedicas(observacao, dt_conclusao, id_especialidade, id_medico));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteEspecialidadesMedicas(int id){
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

    public boolean updateEspecialidadesMedicas(EspecialidadesMedicas entidade, int id) {
        try (PreparedStatement preparedStatement = prepararSQL(UPDATE_SQL)) {
            preparedStatement.setString(1, entidade.getObservacao());
            preparedStatement.setDate(2, entidade.getDt_conclusao());
            preparedStatement.setInt(3, entidade.getId_especialidade());
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