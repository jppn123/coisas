package DAO;

import model.ReceitasOculos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReceitasOculosDAO extends ConexaoDB {

    private static final String INSERT_SQL = "INSERT INTO receitas_oculos (detalhamento, dt_consulta, id_consulta_medica) VALUES (?, ?, ?);";
    private static final String SELECT_BY_ID = "SELECT * FROM receitas_oculos WHERE id = ?";
    private static final String SELECT_ALL = "SELECT * FROM receitas_oculos;";
    private static final String DELETE_SQL = "DELETE FROM receitas_oculos WHERE id = ?;";
    private static final String UPDATE_SQL = "UPDATE receitas_oculos SET detalhamento = ?, dt_consulta = ?, id_consulta_medica = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM receitas_oculos;";

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
    public void insertReceitasOculos(ReceitasOculos entidade){
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_SQL)) {
            preparedStatement.setString(1, entidade.getDetalhamento());
            preparedStatement.setDate(2, entidade.getDt_consulta());
            preparedStatement.setInt(3, entidade.getId_consulta_medica());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("O id da uf inserido não existe!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ReceitasOculos selectReceitasOculos(int id) {
        ReceitasOculos entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String detalhamento = rs.getString("detalhamento");
                Date dt_consulta = rs.getDate("dt_consulta");
                Integer id_consulta_medica = rs.getInt("id_consulta_medica");
                entidade = new ReceitasOculos(detalhamento, dt_consulta, id_consulta_medica);
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
    public List<ReceitasOculos> selectAllReceitasOculos() {

        List<ReceitasOculos> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String detalhamento = rs.getString("detalhamento");
                Date dt_consulta = rs.getDate("dt_consulta");
                Integer id_consulta_medica = rs.getInt("id_consulta_medica");
                entidades.add(new ReceitasOculos(detalhamento, dt_consulta, id_consulta_medica));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteReceitasOculos(int id){
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

    public boolean updateReceitasOculos(ReceitasOculos entidade, int id) {
        try (PreparedStatement preparedStatement = prepararSQL(UPDATE_SQL)) {
            preparedStatement.setString(1, entidade.getDetalhamento());
            preparedStatement.setDate(2, entidade.getDt_consulta());
            preparedStatement.setInt(3, entidade.getId_consulta_medica());
            preparedStatement.setInt(4, id);

            return preparedStatement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}