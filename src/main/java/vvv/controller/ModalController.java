package main.java.vvv.controller;

import java.sql.Date;
import java.util.List;

import main.java.vvv.dao.ModalDAO;
import main.java.vvv.model.Modal;

public class ModalController {

    private final ModalDAO modalDAO;

    public ModalController(){
        this.modalDAO = new ModalDAO();
    }

    public boolean cadastrarModal(String nome, int capacidade, Date dataFabricacao, String tipo, long id_companhia){

        try {
            Modal modal = new Modal(nome, capacidade, dataFabricacao, id_companhia, tipo);
            modalDAO.cadastrarModal(modal);

            return true;
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }

    public List<Modal> listarModal() {
        return modalDAO.listarModal();
    }

    // Deletar modal pelo ID
    public boolean deletarModal(long id) {
        try {
            return modalDAO.deletarModal(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Atualizar modal
    public boolean atualizarModal(long id, String nome, int capacidade) {
        try {
            return modalDAO.atualizarModal(id, nome, capacidade);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
