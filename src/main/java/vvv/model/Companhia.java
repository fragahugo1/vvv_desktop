package main.java.vvv.model;

import java.time.LocalDate;

public class Companhia {

    private long id;
    private String nome;
    private String cnpj;
    private LocalDate activatedAt;
    private LocalDate updatedAt;
    private LocalDate inactivatedAt;

    public Companhia(){
    }

    public Companhia(String nome, String cnpj, LocalDate activatedAt) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.activatedAt = activatedAt;
    }

    public Companhia(String nome,String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public LocalDate getActivatedAt() {
        return activatedAt;
    }

    public void setActivatedAt(LocalDate activatedAt) {
        this.activatedAt = activatedAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDate getInactivatedAt() {
        return inactivatedAt;
    }

    public void setInactivatedAt(LocalDate inactivatedAt) {
        this.inactivatedAt = inactivatedAt;
    }

    public void cadastrarCompanhia(Companhia companhia){
    }
}