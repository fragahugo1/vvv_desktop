package main.java.vvv.dao;

import main.java.vvv.model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    /**
     * Cadastra um novo cliente no banco de dados.
     */
    public boolean cadastrarCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (nome, cpf) VALUES (?, ?)";
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = new ConnectionMVC().getConnection();
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0; // Retorna verdadeiro se o cadastro foi bem-sucedido.

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Retorna uma lista de todos os clientes cadastrados no banco.
     */
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT id, nome, cpf FROM cliente";
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = new ConnectionMVC().getConnection();
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                clientes.add(cliente);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return clientes;
    }
}