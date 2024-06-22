package DAO;

import model.Medicos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicosDAO extends ConexaoDB {

    private static final String INSERT_SQL = "INSERT INTO medicos (nome, crm) VALUES (?, ?);";
    private static final String SELECT_BY_ID = "SELECT * FROM medicos WHERE id = ?";
    private static final String SELECT_ALL = "SELECT * FROM medicos;";
    private static final String DELETE_SQL = "DELETE FROM medicos WHERE id = ?;";
    private static final String UPDATE_SQL = "UPDATE medicos SET nome = ?, crm = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM medicos;";

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
    public void insertMedicos(Medicos entidade){
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_SQL)) {
            preparedStatement.setString(1, entidade.getNome());
            preparedStatement.setString(2, entidade.getCrm());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("O id da uf inserido não existe!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Medicos selectMedicos(int id) {
        Medicos entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                String crm = rs.getString("crm");
                entidade = new Medicos(nome, crm);
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
    public List<Medicos> selectAllMedicos() {

        List<Medicos> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                String crm = rs.getString("crm");
                entidades.add(new Medicos(nome, crm));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteMedicos(int id){
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

    public boolean updateMedicos(Medicos entidade, int id) {
        try (PreparedStatement preparedStatement = prepararSQL(UPDATE_SQL)) {
            preparedStatement.setString(1, entidade.getNome());
            preparedStatement.setString(2, entidade.getCrm());
            preparedStatement.setInt(3, id);

            return preparedStatement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}