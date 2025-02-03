package main.java.vvv.model;

public class Local {

    private Long id;
    private String name;
    private int id_endereco;
    private String tipo;

    public Local() {
    }

    public Local(String name, int id_endereco, String tipo) {
        this.name = name;
        this.id_endereco = id_endereco;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdEndereco() {
        return id_endereco;
    }

    public void setIdEndereco(int id_endereco) {
        this.id_endereco = id_endereco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
