package DAO;

import model.AtributosEstruturaLente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AtributosEstruturaLenteDAO extends ConexaoDB {

    private static final String INSERT_SQL = "INSERT INTO atributos_estrutura_lente (descricao, lado_olho) VALUES (?, ?);";
    private static final String SELECT_BY_ID = "SELECT * FROM atributos_estrutura_lente WHERE id = ?";
    private static final String SELECT_ALL = "SELECT * FROM atributos_estrutura_lente;";
    private static final String DELETE_SQL = "DELETE FROM atributos_estrutura_lente WHERE id = ?;";
    private static final String UPDATE_SQL = "UPDATE atributos_estrutura_lente SET descricao = ?, lado_olho = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM atributos_estrutura_lente;";

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
    public void insertAtributosEstruturaLente(AtributosEstruturaLente entidade){
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_SQL)) {
            preparedStatement.setString(1, entidade.getDescricao());
            preparedStatement.setString(2, entidade.getLado_olho());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("O id da uf inserido não existe!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public AtributosEstruturaLente selectAtributosEstruturaLente(int id) {
        AtributosEstruturaLente entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                String lado_olho = rs.getString("lado_olho");
                entidade = new AtributosEstruturaLente(descricao, lado_olho);
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
    public List<AtributosEstruturaLente> selectAllAtributosEstruturaLente() {

        List<AtributosEstruturaLente> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                String lado_olho = rs.getString("lado_olho");
                entidades.add(new AtributosEstruturaLente(descricao, lado_olho));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteAtributosEstruturaLente(int id){
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

    public boolean updateAtributosEstruturaLente(AtributosEstruturaLente entidade, int id) {
        try (PreparedStatement preparedStatement = prepararSQL(UPDATE_SQL)) {
            preparedStatement.setString(1, entidade.getDescricao());
            preparedStatement.setString(2, entidade.getLado_olho());
            preparedStatement.setInt(3, id);

            return preparedStatement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}