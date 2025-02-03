package main.java.vvv.dao;

import main.java.vvv.model.Loja;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LojaDAO {

    public boolean cadastrarLoja(Loja loja) throws ExceptionDAO {

        String sql = "INSERT INTO loja (nome, cnpj, virtualmente, id_endereco) VALUES (?, ?, ?, ?)";
        PreparedStatement pstm = null;
        Connection conn = null;
        boolean sucesso = false;

        try {
            conn = new ConnectionMVC().getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, loja.getNome());
            pstm.setString(2, loja.getCnpj());
            pstm.setBoolean(3, loja.isVirtualmente());

            // Se a loja for virtual, insere NULL na FOREIGN KEY
            if (loja.isVirtualmente()) {
                pstm.setNull(4, java.sql.Types.INTEGER);
            } else {
                pstm.setInt(4, loja.getIdEndereco());
            }

            int rowsinserted = pstm.executeUpdate();
            sucesso = rowsinserted > 0;

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao cadastrar loja: " + e.getMessage());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar o statement: " + e);
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar a conexão: " + e);
            }
        }
        return sucesso;
    }
}