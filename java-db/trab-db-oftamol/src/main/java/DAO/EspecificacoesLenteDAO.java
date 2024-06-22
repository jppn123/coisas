package DAO;

import model.EspecificacoesLente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EspecificacoesLenteDAO extends ConexaoDB {

    private static final String INSERT_SQL = "INSERT INTO especificacoes_lente (valor, id_estrutura_lente, id_atributo_estrutura_lente) VALUES (?, ?, ?);";
    private static final String SELECT_BY_ID = "SELECT * FROM especificacoes_lente WHERE id = ?";
    private static final String SELECT_ALL = "SELECT * FROM especificacoes_lente;";
    private static final String DELETE_SQL = "DELETE FROM especificacoes_lente WHERE id = ?;";
    private static final String UPDATE_SQL = "UPDATE especificacoes_lente SET valor = ?, id_estrutura_lente = ?, id_atributo_estrutura_lente = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM especificacoes_lente;";

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
    public void insertEspecificacoesLente(EspecificacoesLente entidade){
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_SQL)) {
            preparedStatement.setDouble(1, entidade.getValor());
            preparedStatement.setInt(2, entidade.getId_estrutura_lente());
            preparedStatement.setInt(3, entidade.getId_atributo_estrutura_lente());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("O id da uf inserido não existe!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public EspecificacoesLente selectEspecificacoesLente(int id) {
        EspecificacoesLente entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Double valor = rs.getDouble("valor");
                Integer distancia_pupilar = rs.getInt("id_estrutura_lente");
                Integer id_receita_oculos = rs.getInt("id_atributo_estrutura_lente");
                entidade = new EspecificacoesLente(valor, distancia_pupilar, id_receita_oculos);
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
    public List<EspecificacoesLente> selectAllEspecificacoesLente() {

        List<EspecificacoesLente> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Double valor = rs.getDouble("valor");
                Integer distancia_pupilar = rs.getInt("id_estrutura_lente");
                Integer id_receita_oculos = rs.getInt("id_atributo_estrutura_lente");
                entidades.add(new EspecificacoesLente(valor, distancia_pupilar, id_receita_oculos));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteEspecificacoesLente(int id){
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

    public boolean updateEspecificacoesLente(EspecificacoesLente entidade, int id) {
        try (PreparedStatement preparedStatement = prepararSQL(UPDATE_SQL)) {
            preparedStatement.setDouble(1, entidade.getValor());
            preparedStatement.setInt(2, entidade.getId_estrutura_lente());
            preparedStatement.setInt(3, entidade.getId_atributo_estrutura_lente());
            preparedStatement.setInt(4, id);

            return preparedStatement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}