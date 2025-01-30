package main.java.vvv.model;

public class Local {

    private Long id;
    private String name;
    private Long id_endereco;
    private TipoLocal tipo;

    // Enum para o tipo
    public enum TipoLocal {
        aeroporto, rodoviaria, porto
    }

    public Local() {
    }

    public Local(String name, Long id_endereco, TipoLocal tipo) {
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

    public Long getIdEndereco() {
        return id_endereco;
    }

    public void setIdEndereco(Long id_endereco) {
        this.id_endereco = id_endereco;
    }

    public TipoLocal getTipo() {
        return tipo;
    }

    public void setTipo(TipoLocal tipo) {
        this.tipo = tipo;
    }
}
