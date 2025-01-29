package main.java.vvv.model;

public class Endereco {

    private long id;
    private String rua;
    private int numero;
    private String pais;
    private String codigoPostal;
    private String longitude;
    private String latitude;

    // Construtor vazio
    public Endereco() {
    }

    // Construtor com parâmetros
    public Endereco(String rua, int numero, String pais, String codigoPostal, String longitude, String latitude) {
        this.rua = rua;
        this.numero = numero;
        this.pais = pais;
        this.codigoPostal = codigoPostal;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    // Getters e Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
