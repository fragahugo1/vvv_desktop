package main.java.vvv.dao;

import main.java.vvv.model.Reserva;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReservaDAO {

    public boolean cadastrarReserva(Reserva reserva) throws ExceptionDAO {
        String sql = "INSERT INTO reserva (data, chegada, partida, status, id_cliente, id_modal) VALUES (?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;
        boolean sucesso = false;

        try {
            conn = ConnectionMVC.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setDate(1, (Date) reserva.getData());
            pstm.setDate(2, (Date) reserva.getChegada());
            pstm.setDate(3, (Date) reserva.getPartida());
            pstm.setBoolean(4, reserva.isStatus());
            pstm.setLong(5, reserva.getId_cliente());
            pstm.setLong(6, reserva.getId_modal());

            int linhasAfetadas = pstm.executeUpdate();
            sucesso = linhasAfetadas > 0;

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao cadastrar reserva: " + e.getMessage());
        } finally {
            try {
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sucesso;
    }
}
