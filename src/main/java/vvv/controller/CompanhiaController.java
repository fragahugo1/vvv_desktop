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

    public List<Companhia> listarCompanhias(){
        List<Companhia> companhias = companhiaDAO.listarCompanhias();
        return companhias;
    }


    public boolean deletarCompanhia(long id){

        try {
            Companhia companhia = companhiaDAO.buscarPorId(id);
            companhiaDAO.deletarCompanhia(companhia);

            return true;
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }

    public boolean atualizarCompanhia(long id, String nome, String cnpj){

        try{
            LocalDate updatedAt = LocalDate.now();
            Companhia companhia = companhiaDAO.buscarPorId(id);

            companhia.setNome(nome);
            companhia.setCnpj(cnpj);
            companhia.setUpdatedAt(updatedAt);

            companhiaDAO.atualizarCompanhia(companhia);
            return true;
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }
}
