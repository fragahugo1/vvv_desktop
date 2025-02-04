package main.java.vvv.model;

import java.sql.Date;

public class Reserva {
    private long id;
    private Date dataReserva;
    private Date dataPartida;
    private Date dataChegada;
    private long idCliente;
    private long idModal;

    // Construtor
    public Reserva(Date dataReserva, Date dataPartida, Date dataChegada, long idCliente, long idModal) {
        this.dataReserva = dataReserva;
        this.dataPartida = dataPartida;
        this.dataChegada = dataChegada;
        this.idCliente = idCliente;
        this.idModal = idModal;
    }

    // Getters e Setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public Date getDataReserva() { return dataReserva; }
    public void setDataReserva(Date dataReserva) { this.dataReserva = dataReserva; }

    public Date getDataPartida() { return dataPartida; }
    public void setDataPartida(Date dataPartida) { this.dataPartida = dataPartida; }

    public Date getDataChegada() { return dataChegada; }
    public void setDataChegada(Date dataChegada) { this.dataChegada = dataChegada; }

    public long getIdCliente() { return idCliente; }
    public void setIdCliente(long idCliente) { this.idCliente = idCliente; }

    public long getIdModal() { return idModal; }
    public void setIdModal(long idModal) { this.idModal = idModal; }
}