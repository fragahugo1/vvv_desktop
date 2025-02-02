package main.java.vvv.model;

public class Ticket {

    private long id;
    private String assento;
    private long id_reserva;

    public Ticket() {
    }

    public Ticket(String assento, long id_reserva) {
        this.assento = assento;
        this.id_reserva = id_reserva;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAssento() {
        return assento;
    }

    public void setAssento(String assento) {
        this.assento = assento;
    }

    public long getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(long id_reserva) {
        this.id_reserva = id_reserva;
    }
}
