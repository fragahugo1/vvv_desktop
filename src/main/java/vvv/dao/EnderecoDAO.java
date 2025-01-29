package main.java.vvv.dao;

import main.java.vvv.model.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnderecoDAO {

    public boolean cadastrarEndereco(Endereco endereco) throws ExceptionDAO {
        String sql = "INSERT INTO endereco (rua, numero, pais, codigoPostal, longitude, latitude) VALUES (?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;
        boolean sucesso = false;

        try {
            conn = ConnectionMVC.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, endereco.getRua());
            pstm.setInt(2, endereco.getNumero());
            pstm.setString(3, endereco.getPais());
            pstm.setString(4, endereco.getCodigoPostal());
            pstm.setString(5, endereco.getLongitude());
            pstm.setString(6, endereco.getLatitude());

            int linhasAfetadas = pstm.executeUpdate();
            sucesso = linhasAfetadas > 0;

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao cadastrar endereço: " + e.getMessage());
        } finally {
            try {
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sucesso;
    }
}