package main.java.vvv.controller;

import main.java.vvv.dao.UsuarioDAO;
import main.java.vvv.model.Usuario;


public class UsuarioController {
    private UsuarioDAO usuarioDAO;

    public UsuarioController() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public Usuario autenticarUsuario(String login, String senha) {
        return usuarioDAO.autenticar(login, senha); // Retorna o objeto usuário
    }

    public boolean cadastrarUsuario(String login, String senha, int id_level) {

        try {

            Usuario usuario = new Usuario(login, senha, id_level);
            usuarioDAO.cadastrarUsuario(usuario);

            return true;
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }
}