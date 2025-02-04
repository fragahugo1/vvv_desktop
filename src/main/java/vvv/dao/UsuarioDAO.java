package main.java.vvv.dao;

import main.java.vvv.model.Usuario;
import main.java.vvv.dao.ConnectionMVC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public Usuario autenticar(String login, String senha) {
        Usuario usuario = null;
        String sql = "SELECT login, senha, id_level FROM usuario WHERE login = ? AND senha = ?";

        try {
            Connection conn = ConnectionMVC.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setNivel(rs.getInt("id_level")); // Obtém o nível do usuário
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return usuario; // Retorna null se não encontrar o usuário
    }

    public boolean cadastrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario (login, senha, id_level) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionMVC.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
            stmt.setInt(3, usuario.getNivel());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Retorna verdadeiro se o cadastro for bem-sucedido

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}