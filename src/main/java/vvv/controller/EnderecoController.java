package main.java.vvv.controller;

import main.java.vvv.dao.EnderecoDAO;
import main.java.vvv.model.Endereco;

import java.util.List;

public class EnderecoController {

    private final EnderecoDAO enderecoDAO;

    public EnderecoController(){
        this.enderecoDAO = new EnderecoDAO();
    }

    public boolean cadastrarEndereco(String rua, int numero, String pais, String codigoPostal, String longitude, String latitude) {

        try {
            Endereco endereco = new Endereco(rua, numero, pais, codigoPostal, longitude, latitude);
            enderecoDAO.cadastrarEndereco(endereco);

            return true;
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }

    public List<Endereco> listarEnderecos() {
        return enderecoDAO.listarEnderecos();
    }
}
