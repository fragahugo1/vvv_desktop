package main.java.vvv.model;

import java.sql.Date;

public class Modal {

    private long id;
    private int capacidade;
    private Date dataFabricacao;
    private long id_companhia;
    private Local partida;
    private Local chegada;
    private TipoModal tipo;

    // Enum para o tipo
    public enum TipoModal{
        aviao, onibus, navio, trem
    }

    public Modal() {
    }

    public Modal(int capacidade, Date dataFabricacao, long id_companhia, Local partida, Local chegada, TipoModal tipo) {
        this.capacidade = capacidade;
        this.dataFabricacao = dataFabricacao;
        this.id_companhia = id_companhia;
        this.partida = partida;
        this.chegada = chegada;
        this.tipo = tipo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public long getId_companhia() {
        return id_companhia;
    }

    public void setId_companhia(long id_companhia) {
        this.id_companhia = id_companhia;
    }

    public Local getPartida() {
        return partida;
    }

    public void setPartida(Local partida) {
        this.partida = partida;
    }

    public Local getChegada() {
        return chegada;
    }

    public void setChegada(Local chegada) {
        this.chegada = chegada;
    }

    public TipoModal getTipo() {
        return tipo;
    }

    public void setTipo(TipoModal tipo) {
        this.tipo = tipo;
    }
}
