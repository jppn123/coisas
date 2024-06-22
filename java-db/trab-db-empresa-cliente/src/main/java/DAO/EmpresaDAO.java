package DAO;

import model.Empresa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpresaDAO extends ConexaoDB {

    private static final String INSERT_SQL = "INSERT INTO empresa (nome_fantasia, cnpj, slogan, id_endereco) VALUES (?, ?, ?, ?);";
    private static final String SELECT_BY_ID = "SELECT * FROM empresa WHERE id = ?";
    private static final String SELECT_ALL = "SELECT * FROM empresa;";
    private static final String DELETE_SQL = "DELETE FROM empresa WHERE id = ?;";
    private static final String UPDATE_SQL = "UPDATE empresa SET nome_fantasia = ?, cnpj = ?, slogan = ?, id_endereco = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM empresa;";

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
    public void verificaCNPJIgual(String cnpj){
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL)){
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String cnpjData = rs.getString("cnpj");
                if (cnpjData.equals(cnpj)){
                    System.out.println("O cnpj inserido já existe!");
                    return;
                }
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void insertEmpresa(Empresa entidade){
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_SQL)) {
            preparedStatement.setString(1, entidade.getNome());
            preparedStatement.setString(2, entidade.getCnpj());
            preparedStatement.setString(3, entidade.getSlogan());
            preparedStatement.setInt(4, entidade.getIdEndereco());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Empresa selectEmpresa(int id) {
        Empresa entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome_fantasia");
                String cnpj = rs.getString("cnpj");
                String slogan = rs.getString("slogan");
                Integer id_endereco = rs.getInt("id_endereco");
                entidade = new Empresa(nome, cnpj, slogan, id_endereco);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }
    
    public List<Empresa> selectAllEmpresa() {

        List<Empresa> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome_fantasia");
                String cnpj = rs.getString("cnpj");
                String slogan = rs.getString("slogan");
                Integer id_endereco = rs.getInt("id_endereco");
                entidades.add(new Empresa(nome, cnpj, slogan, id_endereco));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteEmpresa(int id){
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

    public boolean updateEmpresa(Empresa entidade, int id) {
        try (PreparedStatement preparedStatement = prepararSQL(UPDATE_SQL)) {
            preparedStatement.setString(1, entidade.getNome());
            preparedStatement.setString(2, entidade.getCnpj());
            preparedStatement.setString(3, entidade.getSlogan());
            preparedStatement.setInt(4, entidade.getIdEndereco());
            preparedStatement.setInt(5, id);

            return preparedStatement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}