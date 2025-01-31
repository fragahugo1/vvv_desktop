package main.java.vvv.controller;

import main.java.vvv.dao.LojaDAO;
import main.java.vvv.model.Loja;

public class LojaController {

    private final LojaDAO lojaDAO;

    public LojaController(){
        this.lojaDAO = new LojaDAO();
    }

    public boolean cadastrarLoja(String nome, String cnpj, boolean virtualmente, long id_endereco){

        try {
            Loja loja = new Loja(nome, cnpj, virtualmente, id_endereco);
            lojaDAO.cadastrarLoja(loja);

            return true;
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }
}
