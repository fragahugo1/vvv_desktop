package main.java.vvv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import main.java.vvv.dao.ConnectionMVC;

public class PassageiroDAO {

    public boolean cadastrarPassageiro(String nome, String cpf, int idCliente) {
        String sql = "INSERT INTO passageiro (nome, cpf, id_cliente) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionMVC.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.setInt(3, idCliente);

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}