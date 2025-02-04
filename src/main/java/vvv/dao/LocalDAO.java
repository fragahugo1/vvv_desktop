package main.java.vvv.dao;

import main.java.vvv.model.Local;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LocalDAO {

    public boolean cadastrarLocal(Local local) throws ExceptionDAO {
        String sql = "INSERT INTO local (nome, id_endereco, tipo) VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;
        boolean sucesso = false;

        try {
            conn = ConnectionMVC.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, local.getName());
            pstm.setLong(2, local.getIdEndereco());
            pstm.setString(3, local.getTipo());

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