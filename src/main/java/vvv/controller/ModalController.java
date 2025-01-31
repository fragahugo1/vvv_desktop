package main.java.vvv.controller;

import main.java.vvv.dao.ModalDAO;
import main.java.vvv.model.Local;
import main.java.vvv.model.Modal;
import java.sql.Date;

public class ModalController {

    private final ModalDAO modalDAO;

    public ModalController(){
        this.modalDAO = new ModalDAO();
    }

    public boolean cadastrarModal(int capacidade, Date dataFabricacao, long id_companhia, Local partida,Local chegada, Modal.TipoModal tipo) {

        try {
            Modal modal = new Modal(capacidade, dataFabricacao, id_companhia, partida, chegada, tipo);
            modalDAO.cadastrarModal(modal);

            return true;
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }
}
