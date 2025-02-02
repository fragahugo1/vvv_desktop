package main.java.vvv.controller;

import main.java.vvv.dao.PassageiroDAO;

public class PassageiroController {

    private final PassageiroDAO passageiroDAO;

    public PassageiroController() {
        this.passageiroDAO = new PassageiroDAO();
    }

    public boolean cadastrarPassageiro(String nome, String cpf, int idCliente) {
        try {
            return passageiroDAO.cadastrarPassageiro(nome, cpf, idCliente);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}