package main.java.vvv.dao;

import main.java.vvv.model.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EnderecoDAO {

    public boolean cadastrarEndereco(Endereco endereco) throws ExceptionDAO {
        String sql = "INSERT INTO endereco (rua, numero, pais, codigoPostal, longitude, latitude) VALUES (?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        boolean sucesso = false;

        try {
            conn = ConnectionMVC.getConnection();
            preparedStatement = conn.prepareStatement(sql);
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
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sucesso;
    }

    public List<Endereco> listarEnderecos() {
        List<Endereco> enderecos = new ArrayList<>();
        String sql = "SELECT rua, numero, pais, codigoPostal, longitude, latitude FROM endereco";

        try (Connection conn = ConnectionMVC.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Endereco endereco = new Endereco();
                endereco.setRua(rs.getString("rua"));
                endereco.setNumero(rs.getInt("numero"));
                endereco.setPais(rs.getString("pais"));
                endereco.setCodigoPostal(rs.getString("codigoPostal"));
                endereco.setLongitude(rs.getString("longitude"));
                endereco.setLatitude(rs.getString("latitude"));

                enderecos.add(endereco);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return enderecos;
    }
}