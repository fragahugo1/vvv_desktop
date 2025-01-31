package main.java.vvv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import main.java.vvv.model.Modal;


public class ModalDAO {

    public boolean cadastrarModal(Modal modal) throws ExceptionDAO {
        String sql = "INSERT INTO modal (capacidade, dataFabricacao, id_companhia, tipo) VALUES (?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionMVC.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, modal.getCapacidade());
            pstm.setDate(2, modal.getDataFabricacao());
            pstm.setLong(3, modal.getId_companhia());
            pstm.setString(4, modal.getTipo().name());  // Converte o Enum para String

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
}
