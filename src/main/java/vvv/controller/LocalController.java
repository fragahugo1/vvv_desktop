package main.java.vvv.controller;

import main.java.vvv.model.Local;
import main.java.vvv.dao.LocalDAO;

public class LocalController {
    private LocalDAO localDAO;
    public LocalController() {this.localDAO = new LocalDAO();}

    public boolean cadastrarLocal(String nome, int idEndereco, String tipo) {

        Local local = new Local(nome, idEndereco, tipo);
        LocalDAO localDAO = new LocalDAO();

        try {
            localDAO.cadastrarLocal(local);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
