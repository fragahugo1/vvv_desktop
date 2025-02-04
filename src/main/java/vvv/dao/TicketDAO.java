package main.java.vvv.dao;

import main.java.vvv.model.Ticket;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO {

    public boolean cadastrarTicket(Ticket ticket) throws ExceptionDAO {
        String sql = "INSERT INTO ticket (numeroAssento, id_reserva) VALUES (?, ?)";

        try (Connection conn = ConnectionMVC.getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setInt(1, ticket.getNumeroAssento());
            pstm.setLong(2, ticket.getIdReserva());

            return pstm.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao cadastrar ticket: " + e.getMessage());
        }
    }

}
