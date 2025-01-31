package main.java.vvv.controller;

import main.java.vvv.dao.EnderecoDAO;
import main.java.vvv.model.Endereco;

import java.time.LocalDate;

public class EnderecoController {

    private EnderecoDAO enderecoDAO;

    public EnderecoController(){
        this.enderecoDAO = new EnderecoDAO();
    }

    public boolean cadastrarEndereco(String logradouro, int numero, String pais, String codigoPostal, String longitude, String latitude){

        try {
            LocalDate activatedAt = LocalDate.now();
            Endereco endereco = new Endereco(logradouro, numero, pais, codigoPostal, longitude, latitude);
            enderecoDAO.cadastrarEndereco(endereco);

            return true;
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }
}
