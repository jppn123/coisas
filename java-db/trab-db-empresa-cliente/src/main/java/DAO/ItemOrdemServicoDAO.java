package DAO;

import model.ItemOrdemServico;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemOrdemServicoDAO extends ConexaoDB {

    private static final String INSERT_SQL = "INSERT INTO item_ordem_servico (descricao, preco, id_ordem_servico) VALUES (?, ?, ?);";
    private static final String SELECT_BY_ID = "SELECT * FROM item_ordem_servico WHERE id = ?";
    private static final String SELECT_ALL = "SELECT * FROM item_ordem_servico;";
    private static final String DELETE_SQL = "DELETE FROM item_ordem_servico WHERE id = ?;";
    private static final String UPDATE_SQL = "UPDATE item_ordem_servico SET descricao = ?, preco = ?, id_ordem_servico = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM item_ordem_servico;";


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

    public void insertItemOrdemServico(ItemOrdemServico entidade){
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_SQL)) {
            preparedStatement.setString(1, entidade.getDescricao());
            preparedStatement.setDouble(2, entidade.getPreco());
            preparedStatement.setInt(3, entidade.getIdOrdemServico());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ItemOrdemServico selectItemOrdemServico(int id) {
        ItemOrdemServico entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                Double preco = rs.getDouble("preco");
                Integer id_ordem_servico = rs.getInt("id_ordem_servico");
                entidade = new ItemOrdemServico(descricao, preco, id_ordem_servico);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }
    public List<ItemOrdemServico> selectAllItemOrdemServico() {

        List<ItemOrdemServico> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                Double preco = rs.getDouble("preco");
                Integer id_ordem_servico = rs.getInt("id_ordem_servico");
                entidades.add(new ItemOrdemServico(descricao, preco, id_ordem_servico));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteItemOrdemServico(int id){
        try (PreparedStatement statement = prepararSQL(DELETE_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e){
            printSQLException(e);
        }
        return false;
    }

    public boolean updateItemOrdemServico(ItemOrdemServico entidade, int id) {
        try (PreparedStatement preparedStatement = prepararSQL(UPDATE_SQL)) {
            preparedStatement.setString(1, entidade.getDescricao());
            preparedStatement.setDouble(2, entidade.getPreco());
            preparedStatement.setInt(3, entidade.getIdOrdemServico());
            preparedStatement.setInt(4, id);

            return preparedStatement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}