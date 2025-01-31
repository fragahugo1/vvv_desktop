package main.java.vvv.model;

import java.sql.Date;

public class Modal {

    private long id;
    private int capacidade;
    private Date dataFabricacao;
    private long id_companhia;
    private TipoModal tipo;

    // Enum para o tipo
    public enum TipoModal{
        aviao, onibus, navio, trem
    }

    public Modal() {
    }

    public Modal(int capacidade, Date dataFabricacao, long id_companhia, TipoModal tipo) {
        this.capacidade = capacidade;
        this.dataFabricacao = dataFabricacao;
        this.id_companhia = id_companhia;
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

    public long getIdCompanhia() {
        return id_companhia;
    }

    public void setIdCompanhia(long id_companhia) {
        this.id_companhia = id_companhia;
    }

    public TipoModal getTipo() {
        return tipo;
    }

    public void setTipo(TipoModal tipo) {
        this.tipo = tipo;
    }
}
