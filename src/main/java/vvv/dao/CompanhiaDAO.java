package main.java.vvv.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import main.java.vvv.model.Companhia;

public class CompanhiaDAO {
    
    public boolean cadastrarCompanhia(Companhia companhia) throws ExceptionDAO {

        String sql = "INSERT INTO companhia (nome, cnpj, activatedAt) VALUES (?,?,?)";
        PreparedStatement pstm = null;
        Connection connection = null;

        try {
            connection = new ConnectionMVC().getConnection();
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, companhia.getNome());
            pstm.setString(2, companhia.getCnpj());
            pstm.setDate(3, Date.valueOf(LocalDate.now()));
            int rowsInserted = pstm.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao cadastrar companhia: " + e);
        } finally {

            try {
                if (pstm != null){
                    pstm.close();
                } 
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar o statement: " + e);
            } try {
                if (connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar a conexão: " + e);
            }
        }
    }
}
