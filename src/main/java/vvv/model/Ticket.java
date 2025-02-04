package main.java.vvv.model;

public class Ticket {
    private long id;
    private int numeroAssento;
    private long idReserva;

    // Construtor
    public Ticket(int numeroAssento, long idReserva) {
        this.numeroAssento = numeroAssento;
        this.idReserva = idReserva;
    }

    // Getters e Setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public int getNumeroAssento() { return numeroAssento; }
    public void setNumeroAssento(int numeroAssento) { this.numeroAssento = numeroAssento; }

    public long getIdReserva() { return idReserva; }
    public void setIdReserva(long idReserva) { this.idReserva = idReserva; }
}