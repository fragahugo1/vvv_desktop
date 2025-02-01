package main.java.vvv.controller;

import java.sql.Date;

import main.java.vvv.dao.ModalDAO;
import main.java.vvv.model.Modal;
import main.java.vvv.model.Modal.TipoModal;

public class ModalController {

    private final ModalDAO modalDAO;

    public ModalController(){
        this.modalDAO = new ModalDAO();
    }

    public boolean cadastrarModal(int capacidade, Date dataFabricacao, int id_companhia, TipoModal tipo){

        try {
            Modal modal = new Modal(capacidade, dataFabricacao, id_companhia, tipo);
            modalDAO.cadastrarModal(modal);

            return true;
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }

}
