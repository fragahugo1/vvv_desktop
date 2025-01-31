package main.java.vvv.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import main.java.vvv.dao.CompanhiaDAO;
import main.java.vvv.dao.ConnectionMVC;
import main.java.vvv.model.Companhia;

public class CompanhiaController {

    private CompanhiaDAO companhiaDAO;

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


}
