package main.java.vvv.controller;

import java.util.List;

import main.java.vvv.dao.ClienteDAO;
import main.java.vvv.model.Cliente;

public class ClienteController {

    private final ClienteDAO clienteDAO;

    public ClienteController(){
        this.clienteDAO = new ClienteDAO();
    }

    public boolean cadastrarCliente(String nome, String cpf){

        try {

            Cliente cliente = new Cliente(nome, cpf);
            clienteDAO.cadastrarCliente(cliente);

            return true;
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }

    public List<Cliente> listarClientes(){
        try {
            return clienteDAO.listarClientes();
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
