package main.java.vvv.dao;

import main.java.vvv.model.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnderecoDAO {

    public boolean cadastrarEndereco(Endereco endereco) throws ExceptionDAO {
        String sql = "INSERT INTO endereco (rua, numero, pais, codigoPostal, longitude, latitude) VALUES (?, ?, ?, ?, ?, ?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean sucesso = false;

        try {
            connection = ConnectionMVC.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, endereco.getRua());
            preparedStatement.setInt(2, endereco.getNumero());
            preparedStatement.setString(3, endereco.getPais());
            preparedStatement.setString(4, endereco.getCodigoPostal());
            preparedStatement.setString(5, endereco.getLongitude());
            preparedStatement.setString(6, endereco.getLatitude());

            int rowsinserted = preparedStatement.executeUpdate();
            sucesso = rowsinserted > 0;

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao cadastrar endereço: " + e.getMessage());
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sucesso;
    }
}