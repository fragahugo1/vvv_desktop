package main.java.vvv.dao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import main.java.vvv.model.Companhia;

public class CompanhiaDAO {
    
    public boolean cadastrarCompanhia(Companhia companhia) throws ExceptionDAO {

        String sql = "INSERT INTO companhia (nome, cnpj, activatedAt) VALUES (?,?,?)";
        PreparedStatement preparedStatement = null;
        Connection connection = null;

        try {
            connection = ConnectionMVC.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, companhia.getNome());
            preparedStatement.setString(2, companhia.getCnpj());
            preparedStatement.setDate(3, Date.valueOf(companhia.getActivatedAt()));

            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao cadastrar companhia: " + e);
        } finally {

            try {
                if (preparedStatement != null){
                    preparedStatement.close();
                } 
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar o statement: " + e);
            } try {
                if (connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar a conexão: " + e);
            }
        }
    }

    public List<Companhia> listarCompanhias() {
        List<Companhia> lista = new ArrayList<>();
        String sql = "SELECT id, nome, cnpj FROM companhia";
        Connection connection = null;

        try {
            connection = new ConnectionMVC().getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Companhia c = new Companhia();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setCnpj(rs.getString("cnpj"));
                lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Companhia buscarPorId(long id) {
        String sql = "SELECT * FROM companhia WHERE id = ?";
        Companhia companhia = null;
        Connection connection = null;

        try {
            connection = new ConnectionMVC().getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                companhia = new Companhia(
                        rs.getString("nome"),
                        rs.getString("cnpj")
                );
                companhia.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return companhia;
    }

    public boolean deletarCompanhia(Companhia companhia) {
        long id = companhia.getId();

        String sql = "DELETE FROM companhia WHERE id = ?";
        Connection connection = null;

        try {
            connection = new ConnectionMVC().getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean atualizarCompanhia(Companhia companhia) {
        long id = companhia.getId();

        String sql = "UPDATE companhia SET nome = ?, cnpj = ?, updatedAt = ? WHERE id = ?";
        Connection connection = null;

        try{
            connection = new ConnectionMVC().getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, companhia.getNome());
            stmt.setString(2, companhia.getCnpj());
            stmt.setDate(3, Date.valueOf(companhia.getUpdatedAt()));
            stmt.setLong(4, id);

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
