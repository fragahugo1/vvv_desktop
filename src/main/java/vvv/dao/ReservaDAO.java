package main.java.vvv.dao;

import main.java.vvv.model.Reserva;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {

    public boolean cadastrarReserva(Reserva reserva) throws ExceptionDAO {
        String sql = "INSERT INTO reserva (data, partida, chegada, id_cliente, id_modal) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionMVC.getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setDate(1, reserva.getDataReserva());
            pstm.setDate(2, reserva.getDataPartida());
            pstm.setDate(3, reserva.getDataChegada());
            pstm.setLong(4, reserva.getIdCliente());
            pstm.setLong(5, reserva.getIdModal());

            return pstm.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao cadastrar reserva: " + e.getMessage());
        }
    }

    public List<Reserva> listarReservas() {
        List<Reserva> lista = new ArrayList<>();
        String sql = "SELECT * FROM reserva";

        try (Connection conn = ConnectionMVC.getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery()) {

            while (rs.next()) {
                Reserva reserva = new Reserva(
                        rs.getDate("data"),
                        rs.getDate("partida"),
                        rs.getDate("chegada"),
                        rs.getLong("id_cliente"),
                        rs.getLong("id_modal")
                );
                reserva.setId(rs.getLong("id"));
                lista.add(reserva);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

}
