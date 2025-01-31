package main.java.vvv.dao;

import main.java.vvv.model.Local;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LocalDAO {

    public boolean cadastrarLocal(Local local) throws ExceptionDAO {
        String sql = "INSERT INTO local (id, name, id_endereco, tipo) VALUES (?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;
        boolean sucesso = false;

        try {
            conn = ConnectionMVC.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setLong(1, local.getId());
            pstm.setString(2, local.getNome());
            pstm.setLong(3, local.getIdEndereco());
            pstm.setString(4, local.getTipo().name());

            int linhasAfetadas = pstm.executeUpdate();
            sucesso = linhasAfetadas > 0;

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao cadastrar local: " + e.getMessage());
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