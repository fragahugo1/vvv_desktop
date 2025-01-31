package main.java.vvv.model;

public class Loja {

    private long id;
    private String nome;
    private String cnpj;
    private boolean virtualmente;
    private long id_endereco;

    public Loja() {
    }

    public Loja(String nome, String cnpj, boolean virtualmente, long id_endereco) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.virtualmente = virtualmente;
        this.id_endereco = id_endereco;
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

    public boolean isVirtualmente() {
        return virtualmente;
    }

    public void setVirtualmente(boolean virtualmente) {
        this.virtualmente = virtualmente;
    }

    public long getIdEndereco() {
        return id_endereco;
    }

    public void setIdEndereco(long id_endereco) {
        this.id_endereco = id_endereco;
    }
}
