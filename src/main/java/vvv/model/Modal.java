package main.java.vvv.model;

import java.sql.Date;

public class Modal {

    private long id;
    private String nome;
    private int capacidade;
    private Date dataFabricacao;
    private long id_companhia;
    private String tipo;


    public Modal() {
    }

    public Modal(String nome, int capacidade, Date dataFabricacao, long id_companhia, String tipo) {
        this.nome = nome;
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
    
    public String getNome() {
    	return nome;
    }
    
    public void setNome(String nome) {
    	this.nome = nome;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
