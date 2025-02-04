package main.java.vvv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import main.java.vvv.model.Modal;


public class ModalDAO {

    public boolean cadastrarModal(Modal modal) throws ExceptionDAO {
        String sql = "INSERT INTO modal (nome, capacidade, dataFabricacao, tipo, id_companhia) VALUES (?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionMVC.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, modal.getNome());
            pstm.setInt(2, modal.getCapacidade());
            pstm.setDate(3, modal.getDataFabricacao());
            pstm.setString(4, modal.getTipo());
            pstm.setLong(5, modal.getIdCompanhia());

            int rowsAffected = pstm.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao cadastrar modal: " + e.getMessage());
        } finally {
            try {
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Modal> listarModal() {
        List<Modal> lista = new ArrayList<>();
        String sql = "SELECT id, nome, capacidade, dataFabricacao, tipo, id_companhia FROM modal";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = ConnectionMVC.getConnection();
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Modal modal = new Modal();
                modal.setId(rs.getLong("id"));
                modal.setNome(rs.getString("nome"));
                modal.setCapacidade(rs.getInt("capacidade"));
                modal.setDataFabricacao(rs.getDate("dataFabricacao"));
                modal.setTipo(rs.getString("tipo"));
                modal.setIdCompanhia(rs.getLong("id_companhia"));
                lista.add(modal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Deletar um modal pelo ID
    public boolean deletarModal(long id) {
        String sql = "DELETE FROM modal WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionMVC.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setLong(1, id);

            int rowsAffected = pstm.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Atualizar um modal
    public boolean atualizarModal(long id, String nome, int capacidade) {
        String sql = "UPDATE modal SET nome = ?, capacidade = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionMVC.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, nome);
            pstm.setInt(2, capacidade);
            pstm.setLong(3, id);

            int rowsAffected = pstm.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
