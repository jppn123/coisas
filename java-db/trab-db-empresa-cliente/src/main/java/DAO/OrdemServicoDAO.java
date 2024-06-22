package DAO;

import model.OrdemServico;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrdemServicoDAO extends ConexaoDB {

    private static final String INSERT_SQL = "INSERT INTO ordem_servico (observacao, dt_abertura, dt_saida, username_responsavel, id_cliente, id_empresa) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String SELECT_BY_ID = "SELECT * FROM ordem_servico WHERE id = ?";
    private static final String SELECT_ALL = "SELECT * FROM ordem_servico;";
    private static final String DELETE_SQL = "DELETE FROM ordem_servico WHERE id = ?;";
    private static final String UPDATE_SQL = "UPDATE ordem_servico SET observacao = ?, dt_abertura = ?, dt_saida = ?, username_responsavel = ?, id_cliente = ?, id_empresa = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM ordem_servico;";

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
    
    public void insertOrdemServico(OrdemServico entidade){
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_SQL)) {
            preparedStatement.setString(1, entidade.getObservacao());
            preparedStatement.setTimestamp(2, entidade.getDt_abertura());
            preparedStatement.setTimestamp(3, entidade.getDt_saida());
            preparedStatement.setString(4, entidade.getUsername_responsavel());
            preparedStatement.setInt(5, entidade.getId_cliente());
            preparedStatement.setInt(6, entidade.getId_empresa());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public OrdemServico selectOrdemServico(int id) {
        OrdemServico entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String observacao = rs.getString("observacao");
                Timestamp dt_abertura = rs.getTimestamp("dt_abertura");
                Timestamp dt_saida = rs.getTimestamp("dt_saida");
                String username_responsavel = rs.getString("username_responsavel");
                Integer id_cliente = rs.getInt("id_cliente");
                Integer id_empresa = rs.getInt("id_empresa");
                entidade = new OrdemServico(observacao, dt_abertura, dt_saida, username_responsavel, id_cliente, id_empresa);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }
    
    public List<OrdemServico> selectAllOrdemServico() {

        List<OrdemServico> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String observacao = rs.getString("observacao");
                Timestamp dt_abertura = rs.getTimestamp("dt_abertura");
                Timestamp dt_saida = rs.getTimestamp("dt_saida");
                String username_responsavel = rs.getString("username_responsavel");
                Integer id_cliente = rs.getInt("id_cliente");
                Integer id_empresa = rs.getInt("id_empresa");
                entidades.add(new OrdemServico(observacao, dt_abertura, dt_saida, username_responsavel, id_cliente, id_empresa));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteOrdemServico(int id){
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

    public boolean updateOrdemServico(OrdemServico entidade, int id) {
        try (PreparedStatement preparedStatement = prepararSQL(UPDATE_SQL)) {
            preparedStatement.setString(1, entidade.getObservacao());
            preparedStatement.setTimestamp(2, entidade.getDt_abertura());
            preparedStatement.setTimestamp(3, entidade.getDt_saida());
            preparedStatement.setString(4, entidade.getUsername_responsavel());
            preparedStatement.setInt(5, entidade.getId_cliente());
            preparedStatement.setInt(6, entidade.getId_empresa());
            preparedStatement.setInt(7, id);

            return preparedStatement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
