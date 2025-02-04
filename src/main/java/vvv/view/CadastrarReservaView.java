package main.java.vvv.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.text.ParseException;
import java.util.List;
import java.text.SimpleDateFormat;

import javax.swing.*;
import main.java.vvv.controller.ClienteController;
import main.java.vvv.controller.ModalController;
import main.java.vvv.controller.ReservaController;
import main.java.vvv.model.Cliente;
import main.java.vvv.model.Modal;

public class CadastrarReservaView extends JFrame {
	
	private SelecionarReservaView parentFrame;
    private JTextField textFieldDataReserva;
    private JTextField textFieldDataPartida;
    private JTextField textFieldDataChegada;
    private JList<String> listaClientes;
    private JList<String> listaModais;
    private DefaultListModel<String> clientesModel;
    private DefaultListModel<String> modaisModel;
    private JButton btnCadastrar;
    
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarReservaView window = new CadastrarReservaView();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    public CadastrarReservaView() {
    	initialize();
    	carregarClientes();
    	carregarModais();
    }
    
    public CadastrarReservaView(SelecionarReservaView parentFrame) {
    	this.parentFrame = parentFrame;
        initialize();
        carregarClientes();
        carregarModais();
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
        setBounds(100, 100, 500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblTitulo = new JLabel("Cadastro de Reserva");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTitulo.setBounds(100, 10, 300, 30);
        getContentPane().add(lblTitulo);

        JLabel lblDataReserva = new JLabel("Data da Reserva:");
        lblDataReserva.setBounds(30, 60, 120, 25);
        getContentPane().add(lblDataReserva);

        textFieldDataReserva = new JTextField();
        textFieldDataReserva.setBounds(160, 60, 150, 25);
        getContentPane().add(textFieldDataReserva);

        JLabel lblDataPartida = new JLabel("Data da Partida:");
        lblDataPartida.setBounds(30, 100, 120, 25);
        getContentPane().add(lblDataPartida);

        textFieldDataPartida = new JTextField();
        textFieldDataPartida.setBounds(160, 100, 150, 25);
        getContentPane().add(textFieldDataPartida);

        JLabel lblDataChegada = new JLabel("Data de Chegada:");
        lblDataChegada.setBounds(30, 140, 120, 25);
        getContentPane().add(lblDataChegada);

        textFieldDataChegada = new JTextField();
        textFieldDataChegada.setBounds(160, 140, 150, 25);
        getContentPane().add(textFieldDataChegada);

        JLabel lblClientes = new JLabel("Selecione um Cliente:");
        lblClientes.setBounds(30, 180, 150, 25);
        getContentPane().add(lblClientes);

        clientesModel = new DefaultListModel<>();
        listaClientes = new JList<>(clientesModel);
        JScrollPane scrollClientes = new JScrollPane(listaClientes);
        scrollClientes.setBounds(30, 210, 180, 100);
        getContentPane().add(scrollClientes);

        JLabel lblModais = new JLabel("Selecione um Modal:");
        lblModais.setBounds(250, 180, 150, 25);
        getContentPane().add(lblModais);

        modaisModel = new DefaultListModel<>();
        listaModais = new JList<>(modaisModel);
        JScrollPane scrollModais = new JScrollPane(listaModais);
        scrollModais.setBounds(250, 210, 180, 100);
        getContentPane().add(scrollModais);

        btnCadastrar = new JButton("Cadastrar Reserva");
        btnCadastrar.setBounds(150, 350, 200, 40);
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarReserva();
                dispose();
            }
        });
        getContentPane().add(btnCadastrar);
    }

    private void carregarClientes() {
        ClienteController clienteController = new ClienteController();
        List<Cliente> clientes = clienteController.listarClientes();
        
        clientesModel.clear();
        for (Cliente c : clientes) {
            clientesModel.addElement(c.getId() + " - " + c.getNome());
        }
    }

    private void carregarModais() {
        ModalController modalController = new ModalController();
        List<Modal> modais = modalController.listarModal();
        
        modaisModel.clear();
        for (Modal m : modais) {
            modaisModel.addElement(m.getId() + " - " + m.getNome());
        }
    }

    private void cadastrarReserva() {
    	 String dataReserva = textFieldDataReserva.getText();
         String dataPartida = textFieldDataPartida.getText();
         String dataChegada = textFieldDataChegada.getText();

         Date dtReservaStr = null;
         Date dtPartidaStr = null;
         Date dtChegadaStr = null;
         SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
         
         try {
             java.util.Date parsedDate = sdf.parse(dataReserva.toString());
             dtReservaStr = new Date(parsedDate.getTime()); 
         } catch (ParseException e) {
             JOptionPane.showMessageDialog(this, "Data de reserva inválida! Use o formato dd/MM/yyyy.", "Erro", JOptionPane.ERROR_MESSAGE);
             return;
         }

         try {
             java.util.Date parsedDate = sdf.parse(dataPartida.toString());
             dtPartidaStr = new Date(parsedDate.getTime()); 
         } catch (ParseException e) {
             JOptionPane.showMessageDialog(this, "Data de reserva inválida! Use o formato dd/MM/yyyy.", "Erro", JOptionPane.ERROR_MESSAGE);
             return;
         }

         try {
             java.util.Date parsedDate = sdf.parse(dataChegada.toString());
             dtChegadaStr = new Date(parsedDate.getTime()); 
         } catch (ParseException e) {
             JOptionPane.showMessageDialog(this, "Data de reserva inválida! Use o formato dd/MM/yyyy.", "Erro", JOptionPane.ERROR_MESSAGE);
             return;
         }

         String clienteSelecionado = listaClientes.getSelectedValue();
         String modalSelecionado = listaModais.getSelectedValue();

         if (clienteSelecionado == null || modalSelecionado == null) {
             JOptionPane.showMessageDialog(this, "Selecione um Cliente e um Modal!", "Erro", JOptionPane.ERROR_MESSAGE);
             return;
         }
         
    	try {
        	         
            long idCliente = Long.parseLong(clienteSelecionado.split(" - ")[0]);
            long idModal = Long.parseLong(modalSelecionado.split(" - ")[0]);

            ReservaController reservaController = new ReservaController();
            reservaController.cadastrarReserva(dtReservaStr, dtPartidaStr, dtChegadaStr, idCliente, idModal);

            JOptionPane.showMessageDialog(this, "Reserva cadastrada com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar reserva: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}