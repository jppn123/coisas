package DAO;

import model.Cliente;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends ConexaoDB {

    private static final String INSERT_SQL = "INSERT INTO cliente (nome, dt_nascimento, cpf, email, id_endereco) VALUES (?, ?, ?, ?, ?);";
    private static final String SELECT_BY_ID = "SELECT * FROM cliente WHERE id = ?";
    private static final String SELECT_ALL = "SELECT * FROM cliente;";
    private static final String DELETE_SQL = "DELETE FROM cliente WHERE id = ?;";
    private static final String UPDATE_SQL = "UPDATE cliente SET nome = ?, dt_nascimento = ?, cpf = ?, email = ?, id_endereco = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM cliente;";


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
    public void verificaCPFIgual(String cpf){
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL)){
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String cpfdata = rs.getString("cpf");
                if (cpfdata.equals(cpf)){
                    System.out.println("A descrição inserida já existe!");
                    return;
                }
            }
        } catch (SQLException e) {
            System.out.println("Houve algum erro no insert!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void insertCliente(Cliente entidade){
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_SQL)) {
            preparedStatement.setString(1, entidade.getNome());
            preparedStatement.setDate(2, entidade.getDt_nascimento());
            preparedStatement.setString(3, entidade.getCpf());
            preparedStatement.setString(4, entidade.getEmail());
            preparedStatement.setInt(5, entidade.getId_endereco());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("O id da uf inserido não existe!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Cliente selectCliente(int id) {
        Cliente entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                Date dt_nascimento = rs.getDate("dt_nascimento");
                String cpf = rs.getString("cpf");
                String email = rs.getString("email");
                Integer id_endereco = rs.getInt("id_endereco");
                entidade = new Cliente(nome, dt_nascimento, cpf, email, id_endereco);
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
    public List<Cliente> selectAllCliente() {

        List<Cliente> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                Date dt_nascimento = rs.getDate("dt_nascimento");
                String cpf = rs.getString("cpf");
                String email = rs.getString("email");
                Integer id_endereco = rs.getInt("id_endereco");
                entidades.add(new Cliente(nome, dt_nascimento, cpf, email, id_endereco));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteCliente(int id){
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

    public boolean updateCliente(Cliente entidade, int id) {
        try (PreparedStatement preparedStatement = prepararSQL(UPDATE_SQL)) {
            preparedStatement.setString(1, entidade.getNome());
            preparedStatement.setDate(2, entidade.getDt_nascimento());
            preparedStatement.setString(3, entidade.getCpf());
            preparedStatement.setString(4, entidade.getEmail());
            preparedStatement.setInt(5, entidade.getId_endereco());
            preparedStatement.setInt(6, id);

            return preparedStatement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}