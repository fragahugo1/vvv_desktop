package main.java.vvv.controller;

import java.sql.Date;
import java.util.List;

import main.java.vvv.dao.ReservaDAO;
import main.java.vvv.model.Reserva;

public class ReservaController {

    private final ReservaDAO reservaDAO;

    public ReservaController() {
        this.reservaDAO = new ReservaDAO();
    }

    public boolean cadastrarReserva(Date dataReserva, Date dataPartida, Date dataChegada, long idCliente, long idModal) {
        try {
            if (dataReserva == null || dataPartida == null || dataChegada == null) {
                throw new IllegalArgumentException("As datas não podem ser nulas.");
            }
            if (idCliente <= 0 || idModal <= 0) {
                throw new IllegalArgumentException("IDs de Cliente e Modal devem ser válidos.");
            }

            Reserva reserva = new Reserva(dataReserva, dataPartida, dataChegada, idCliente, idModal);
            return reservaDAO.cadastrarReserva(reserva);
        } catch (Exception e) {
            System.err.println("Erro ao cadastrar reserva: " + e.getMessage());
            return false;
        }
    }

    public List<Reserva> listarReservas() {
        return reservaDAO.listarReservas();
    }

}