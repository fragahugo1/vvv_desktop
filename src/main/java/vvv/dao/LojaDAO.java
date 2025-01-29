package main.java.vvv.dao;

import main.java.vvv.model.Loja;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LojaDAO {

    public boolean cadastrarLoja(Loja loja) throws ExceptionDAO {
        String sql = "INSERT INTO loja (nome, cnpj, virtualmente, id_endereco) VALUES (?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;
        boolean sucesso = false;

        try {
            conn = ConnectionMVC.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, loja.getNome());
            pstm.setString(2, loja.getCnpj());
            pstm.setBoolean(3, loja.isVirtualmente());
            pstm.setLong(4, loja.getIdEndereco());

            int linhasAfetadas = pstm.executeUpdate();
            sucesso = linhasAfetadas > 0;

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao cadastrar loja: " + e.getMessage());
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