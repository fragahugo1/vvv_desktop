package main.java.vvv.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import main.java.vvv.controller.ClienteController;
import main.java.vvv.controller.PassageiroController;
import main.java.vvv.model.Cliente;

public class CadastrarPassageiroView extends JFrame {

    private JTextField textFieldNome;
    private JTextField textFieldCPF;
    private JTextField textField;
    private DefaultListModel<String> clienteModel;
    private JList<String> listClientes;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CadastrarPassageiroView window = new CadastrarPassageiroView();
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public CadastrarPassageiroView() {
        initialize();
        carregarClientes();
    }

    public CadastrarPassageiroView(SelecionarClienteView parentFrame) {
        initialize();
        carregarClientes();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (parentFrame != null) {
                    parentFrame.setVisible(true); // Torna a janela anterior visível novamente
                }
            }
        });
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {


        setTitle("Cadastro de Passageiro");
        setBounds(100, 100, 450, 550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Cadastro de Passageiro ");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(114, 0, 222, 59);
        getContentPane().add(lblNewLabel);

        JLabel lblVaivoltaViagens = new JLabel("Vai&Volta Viagens");
        lblVaivoltaViagens.setHorizontalAlignment(SwingConstants.CENTER);
        lblVaivoltaViagens.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblVaivoltaViagens.setBounds(114, 11, 222, 114);
        getContentPane().add(lblVaivoltaViagens);

        JLabel lblNome = new JLabel("Nome");
        lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNome.setBounds(85, 108, 71, 30);
        getContentPane().add(lblNome);

        textFieldNome = new JTextField();
        textFieldNome.setBounds(95, 149, 259, 30);
        getContentPane().add(textFieldNome);
        textFieldNome.setColumns(10);

        JLabel lblCPF = new JLabel("CPF");
        lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblCPF.setBounds(85, 190, 71, 30);
        getContentPane().add(lblCPF);

        textFieldCPF = new JTextField();
        textFieldCPF.setColumns(10);
        textFieldCPF.setBounds(95, 231, 259, 30);
        getContentPane().add(textFieldCPF);

        JLabel lblCliente = new JLabel("Cliente");
        lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblCliente.setBounds(85, 285, 71, 30);
        getContentPane().add(lblCliente);

        clienteModel = new DefaultListModel<>();
        listClientes = new JList<>(clienteModel);

        // Adicionando a JList dentro de um JScrollPane
        JScrollPane scrollPaneClientes = new JScrollPane(listClientes);
        scrollPaneClientes.setBounds(95, 320, 259, 80);
        getContentPane().add(scrollPaneClientes);

        JButton btnCadastro = new JButton("Cadastrar");
        btnCadastro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarPassageiro();
            }
        });
        btnCadastro.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnCadastro.setBounds(155, 428, 124, 53);
        getContentPane().add(btnCadastro);

    }

    private void carregarClientes() {
        ClienteController clienteController = new ClienteController();
        List<Cliente> clientes = clienteController.listarClientes();

        clienteModel.clear();

        if (clientes != null) {
            for (Cliente c : clientes) {
                clienteModel.addElement(c.getId() + " - " + c.getNome());
            }
        } else {
            System.out.println("Erro ao carregar clientes.");
        }
    }

    private int getIdClienteSelecionado() {
        String selecionado = listClientes.getSelectedValue();
        if (selecionado != null) {
            return Integer.parseInt(selecionado.split(" - ")[0]);
        }
        return -1;
    }

    private void cadastrarPassageiro() {
        String nome = textFieldNome.getText().trim();
        String cpf = textFieldCPF.getText().trim();
        int idCliente = getIdClienteSelecionado();

        if (nome.isEmpty() || cpf.isEmpty() || idCliente == -1) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos e selecione um cliente!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        PassageiroController passageiroController = new PassageiroController();
        boolean sucesso = passageiroController.cadastrarPassageiro(nome, cpf, idCliente);

        if (sucesso) {
            JOptionPane.showMessageDialog(this, "Passageiro cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            dispose(); // Fecha a janela após o cadastro
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar passageiro!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

}
