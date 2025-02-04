package main.java.vvv.controller;

import main.java.vvv.dao.LojaDAO;
import main.java.vvv.model.Loja;

public class LojaController {

    private final LojaDAO lojaDAO;

    public LojaController(){
        this.lojaDAO = new LojaDAO();
    }

    public boolean cadastrarLoja(String nome, String cnpj, boolean tipo, Integer idEndereco) {
        // Se a loja for virtual, idEndereco será null
        if (tipo) {
            idEndereco = null;
        }

        Loja loja = new Loja(nome, cnpj, tipo, idEndereco);
        LojaDAO lojaDAO = new LojaDAO();

        try {
            lojaDAO.cadastrarLoja(loja);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
