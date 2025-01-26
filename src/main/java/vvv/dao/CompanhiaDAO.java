package main.java.vvv.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import main.java.vvv.model.Companhia;

public class CompanhiaDAO {
    
    public void cadastrarCompanhia(Companhia companhia) throws ExceptionDAO {

        String sql = "INSERT INTO companhia (nome, cnpj, activatedAt) VALUES (?,?,?)";
        PreparedStatement preparedStatement = null;
        Connection connection = null;

        try {
            connection = new ConnectionMVC().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, companhia.getNome());
            preparedStatement.setString(2, companhia.getCnpj());
            preparedStatement.setDate(3, Date.valueOf(companhia.getActivatedAt()));
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao cadastrar companhia: " + e);
        } finally {

            try {
                if (preparedStatement != null){
                    preparedStatement.close();
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
