package main.java.vvv.controller;

import main.java.vvv.dao.ReservaDAO;
import main.java.vvv.model.Reserva;

import java.util.Date;

public class ReservaController {

    private final ReservaDAO reservaDAO;

    public ReservaController(){
        this.reservaDAO = new ReservaDAO();
    }

    public boolean cadastrarReserva(Date data, Date chegada, Date partida, boolean status, long id_cliente, long id_modal) {

        try {
            Reserva reserva = new Reserva(data, chegada, partida, status, id_cliente, id_modal);
            reservaDAO.cadastrarReserva(reserva);

            return true;
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }
}
