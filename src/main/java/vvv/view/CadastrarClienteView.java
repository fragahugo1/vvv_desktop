package main.java.vvv.view;
import main.java.vvv.controller.ClienteController;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class CadastrarClienteView extends JFrame {
    private JTextField textFieldNome;
    private JTextField textFieldCPF;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CadastrarClienteView window = new CadastrarClienteView();
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
    public CadastrarClienteView() {
        initialize();
    }

    public CadastrarClienteView(SelecionarClienteView parentFrame) {
        initialize();

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

        setTitle("Cadastro de Cliente");
        setBounds(100, 100, 450, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Cadastro de Cliente ");
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

        textFieldCPF = new JTextField();
        textFieldCPF.setColumns(10);
        textFieldCPF.setBounds(95, 231, 259, 30);
        getContentPane().add(textFieldCPF);

        JLabel lblCPF = new JLabel("CPF");
        lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblCPF.setBounds(85, 190, 71, 30);
        getContentPane().add(lblCPF);

        JButton btnCadastro = new JButton("Cadastrar");
        btnCadastro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = textFieldNome.getText().trim();
                String cpf = textFieldCPF.getText().trim();

                if (nome.isEmpty() || cpf.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                ClienteController clienteController = new ClienteController();
                boolean sucesso = clienteController.cadastrarCliente(nome, cpf);

                if (sucesso) {
                    JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    dispose(); // Fecha a janela após o cadastro
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnCadastro.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnCadastro.setBounds(155, 297, 124, 53);
        getContentPane().add(btnCadastro);
    }

}