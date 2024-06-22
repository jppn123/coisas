package DAO;

import model.ObservacoesLaudos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ObservacoesLaudosDAO extends ConexaoDB {

    private static final String INSERT_SQL = "INSERT INTO observacoes_laudos (descricao, id_receita_oculos) VALUES (?, ?);";
    private static final String SELECT_BY_ID = "SELECT * FROM observacoes_laudos WHERE id = ?";
    private static final String SELECT_ALL = "SELECT * FROM observacoes_laudos;";
    private static final String DELETE_SQL = "DELETE FROM observacoes_laudos WHERE id = ?;";
    private static final String UPDATE_SQL = "UPDATE observacoes_laudos SET descricao = ?, id_receita_oculos = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM observacoes_laudos;";

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
    public void insertObservacoesLaudos(ObservacoesLaudos entidade){
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_SQL)) {
            preparedStatement.setString(1, entidade.getDescricao());
            preparedStatement.setInt(2, entidade.getId_receita_oculos());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("O id da uf inserido não existe!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ObservacoesLaudos selectObservacoesLaudos(int id) {
        ObservacoesLaudos entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                Integer id_receita_oculos = rs.getInt("id_receita_oculos");
                entidade = new ObservacoesLaudos(descricao, id_receita_oculos);
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
    public List<ObservacoesLaudos> selectAllObservacoesLaudos() {

        List<ObservacoesLaudos> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                Integer id_receita_oculos = rs.getInt("id_receita_oculos");
                entidades.add(new ObservacoesLaudos(descricao, id_receita_oculos));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteObservacoesLaudos(int id){
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

    public boolean updateObservacoesLaudos(ObservacoesLaudos entidade, int id) {
        try (PreparedStatement preparedStatement = prepararSQL(UPDATE_SQL)) {
            preparedStatement.setString(1, entidade.getDescricao());
            preparedStatement.setInt(2, entidade.getId_receita_oculos());
            preparedStatement.setInt(3, id);

            return preparedStatement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}