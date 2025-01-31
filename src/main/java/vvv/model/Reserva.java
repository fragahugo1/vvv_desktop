package main.java.vvv.model;

import java.util.Date;

public class Reserva {

    private long id;
    private Date data;
    private Date chegada;
    private Date partida;
    private boolean status;
    private long id_cliente;
    private long id_modal;

    public Reserva(){
    }

    public Reserva(Date data, Date chegada, Date partida, boolean status, long id_cliente, long id_modal) {
        this.data = data;
        this.chegada = chegada;
        this.partida = partida;
        this.status = status;
        this.id_cliente = id_cliente;
        this.id_modal = id_modal;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getChegada() {
        return chegada;
    }

    public void setChegada(Date chegada) {
        this.chegada = chegada;
    }

    public Date getPartida() {
        return partida;
    }

    public void setPartida(Date partida) {
        this.partida = partida;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public long getId_modal() {
        return id_modal;
    }

    public void setId_modal(long id_modal) {
        this.id_modal = id_modal;
    }
}
