package main.java.vvv.view;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import main.java.vvv.controller.ReservaController;
import main.java.vvv.controller.TicketController;
import main.java.vvv.model.Reserva;

public class CadastrarTicketView extends JFrame {
	
	private SelecionarReservaView parentFrame;
    private JTextField textFieldAssento;
    private JComboBox<String> comboBoxReservas;
    private TicketController ticketController;
    private ReservaController reservaController;
    private List<Reserva> reservas;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                CadastrarTicketView window = new CadastrarTicketView();
                window.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public CadastrarTicketView() {
        ticketController = new TicketController();
        reservaController = new ReservaController();
        initialize();
        carregarReservas();
    }
    
    public CadastrarTicketView(SelecionarReservaView parentFrame) {
        this.parentFrame = parentFrame;
    	ticketController = new TicketController();
        reservaController = new ReservaController();
        initialize();
        carregarReservas();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (parentFrame != null) {
                    parentFrame.setVisible(true); // Torna a janela anterior visível novamente
                }
            }
        });
    }

    private void initialize() {
        setTitle("Cadastrar Ticket");
        setBounds(100, 100, 400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new GridLayout(3, 2, 10, 10));

        JLabel lblAssento = new JLabel("Número do Assento:");
        getContentPane().add(lblAssento);

        textFieldAssento = new JTextField();
        getContentPane().add(textFieldAssento);
        textFieldAssento.setColumns(10);

        JLabel lblReserva = new JLabel("Selecionar Reserva:");
        getContentPane().add(lblReserva);

        comboBoxReservas = new JComboBox<>();
        getContentPane().add(comboBoxReservas);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(e -> cadastrarTicket());
        getContentPane().add(btnSalvar);
    }

    private void carregarReservas() {
        reservas = reservaController.listarReservas();
        comboBoxReservas.removeAllItems();
        
        for (Reserva reserva : reservas) {
            comboBoxReservas.addItem("Reserva ID: " + reserva.getId());
        }
    }

    private void cadastrarTicket() {
        try {
            int numeroAssento = Integer.parseInt(textFieldAssento.getText().trim());
            int indexSelecionado = comboBoxReservas.getSelectedIndex();

            if (indexSelecionado < 0) {
                JOptionPane.showMessageDialog(this, "Selecione uma reserva!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            long idReserva = reservas.get(indexSelecionado).getId();
            boolean sucesso = ticketController.cadastrarTicket(numeroAssento, idReserva);

            if (sucesso) {
                JOptionPane.showMessageDialog(this, "Ticket cadastrado com sucesso!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar o ticket.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Número do assento inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}