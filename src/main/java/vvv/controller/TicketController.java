package main.java.vvv.controller;

import main.java.vvv.dao.TicketDAO;
import main.java.vvv.model.Ticket;
import java.util.List;

public class TicketController {

    private final TicketDAO ticketDAO;

    public TicketController() {
        this.ticketDAO = new TicketDAO();
    }

    public boolean cadastrarTicket(int numeroAssento, long idReserva) {
        try {
            Ticket ticket = new Ticket(numeroAssento, idReserva);
            return ticketDAO.cadastrarTicket(ticket);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}