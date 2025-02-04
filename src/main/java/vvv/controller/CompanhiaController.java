package main.java.vvv.controller;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import main.java.vvv.dao.CompanhiaDAO;
import main.java.vvv.dao.ConnectionMVC;
import main.java.vvv.model.Companhia;

public class CompanhiaController {

    private final CompanhiaDAO companhiaDAO;

    public CompanhiaController(){
        this.companhiaDAO = new CompanhiaDAO();
    }

    public boolean cadastrarCompanhia(String nome, String cnpj){
        
        try {
            LocalDate activatedAt = LocalDate.now();
            Companhia companhia = new Companhia(nome, cnpj, activatedAt);
            companhiaDAO.cadastrarCompanhia(companhia);

            return true;
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }
    
    public List<Companhia> listarCompanhias() {
    	return companhiaDAO.listarCompanhias();
    }


    public boolean deletarCompanhia(int id) {
        try {
            return companhiaDAO.deletarCompanhia(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Atualizar companhia
    public boolean atualizarCompanhia(int id, String nome, String cnpj) {
        try {

            return companhiaDAO.atualizarCompanhia(id, nome, cnpj);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
