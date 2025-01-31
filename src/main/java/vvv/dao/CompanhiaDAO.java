package main.java.vvv.dao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import main.java.vvv.model.Companhia;

public class CompanhiaDAO {
    
    public boolean cadastrarCompanhia(Companhia companhia) throws ExceptionDAO {

        String sql = "INSERT INTO companhia (nome, cnpj, activatedAt) VALUES (?,?,?)";
        PreparedStatement pstm = null;
        Connection connection = null;

        try {
            connection = new ConnectionMVC().getConnection();
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, companhia.getNome());
            pstm.setString(2, companhia.getCnpj());
            pstm.setDate(3, Date.valueOf(LocalDate.now()));
            int rowsInserted = pstm.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao cadastrar companhia: " + e);
        } finally {

            try {
                if (pstm != null){
                    pstm.close();
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
                c.setId(rs.getLong("id"));
                c.setNome(rs.getString("nome"));
                c.setCnpj(rs.getString("cnpj"));
                lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean deletarCompanhia(String nome) {
        String sql = "DELETE FROM companhia WHERE nome = ?";
        Connection connection = null;

        try {
            connection = new ConnectionMVC().getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, nome);
            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean atualizarCompanhia(int id, String nome, String cnpj) {
        String sql = "UPDATE companhia SET nome = ?, cnpj = ? WHERE id = ?";
        Connection connection = null;

        try{
            connection = new ConnectionMVC().getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, nome);
            stmt.setString(2, cnpj);
            stmt.setInt(3, id);

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
