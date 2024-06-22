package DAO;

import model.EstruturasLentes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstruturasLentesDAO extends ConexaoDB {

    private static final String INSERT_SQL = "INSERT INTO estruturas_lentes (tipo_correcao, distancia_pupilar, id_receita_oculos) VALUES (?, ?, ?);";
    private static final String SELECT_BY_ID = "SELECT * FROM estruturas_lentes WHERE id = ?";
    private static final String SELECT_ALL = "SELECT * FROM estruturas_lentes;";
    private static final String DELETE_SQL = "DELETE FROM estruturas_lentes WHERE id = ?;";
    private static final String UPDATE_SQL = "UPDATE estruturas_lentes SET tipo_correcao = ?, distancia_pupilar = ?, id_receita_oculos = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM estruturas_lentes;";

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
    public void insertEstruturasLentes(EstruturasLentes entidade){
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_SQL)) {
            preparedStatement.setString(1, entidade.getTipo_correcao());
            preparedStatement.setInt(2, entidade.getDistancia_pupilar());
            preparedStatement.setInt(3, entidade.getId_receita_oculos());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("O id da uf inserido não existe!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public EstruturasLentes selectEstruturasLentes(int id) {
        EstruturasLentes entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String tipo_correcao = rs.getString("tipo_correcao");
                Integer distancia_pupilar = rs.getInt("distancia_pupilar");
                Integer id_receita_oculos = rs.getInt("id_receita_oculos");
                entidade = new EstruturasLentes(tipo_correcao, distancia_pupilar, id_receita_oculos);
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
    public List<EstruturasLentes> selectAllEstruturasLentes() {

        List<EstruturasLentes> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String tipo_correcao = rs.getString("tipo_correcao");
                Integer distancia_pupilar = rs.getInt("distancia_pupilar");
                Integer id_receita_oculos = rs.getInt("id_receita_oculos");
                entidades.add(new EstruturasLentes(tipo_correcao, distancia_pupilar, id_receita_oculos));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteEstruturasLentes(int id){
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

    public boolean updateEstruturasLentes(EstruturasLentes entidade, int id) {
        try (PreparedStatement preparedStatement = prepararSQL(UPDATE_SQL)) {
            preparedStatement.setString(1, entidade.getTipo_correcao());
            preparedStatement.setInt(2, entidade.getDistancia_pupilar());
            preparedStatement.setInt(3, entidade.getId_receita_oculos());
            preparedStatement.setInt(4, id);

            return preparedStatement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}