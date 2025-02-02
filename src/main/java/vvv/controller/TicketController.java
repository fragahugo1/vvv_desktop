package main.java.vvv.controller;

import main.java.vvv.dao.TicketDAO;
import main.java.vvv.model.Ticket;

public class TicketController {

    private final TicketDAO ticketDAO;

    public TicketController(){
        this.ticketDAO = new TicketDAO();
    }

    public boolean cadastrarTicket(String assento, long id_reserva) {

        try {
            Ticket ticket = new Ticket(assento, id_reserva);
            ticketDAO.cadastrarTiccket(ticket);

            return true;
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }
}
