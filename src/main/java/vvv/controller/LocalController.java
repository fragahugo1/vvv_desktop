package main.java.vvv.controller;

import main.java.vvv.dao.LocalDAO;
import main.java.vvv.model.Local;

public class LocalController {

    private final LocalDAO localDAO;

    public LocalController(){
        this.localDAO = new LocalDAO();
    }

    public boolean cadastrarLocal(String nome, Long id_endereco, Local.TipoLocal tipo) {

        try {
            Local local = new Local(nome, id_endereco, tipo);
            localDAO.cadastrarLocal(local);

            return true;
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }
}
