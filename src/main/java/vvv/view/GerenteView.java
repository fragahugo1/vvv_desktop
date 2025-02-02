package main.java.vvv.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GerenteView extends JFrame {

    private static final long serialVersionUID = 1L;
    private LoginView parentFrame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GerenteView window = new GerenteView();
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
    public GerenteView() {
        initialize();
    }

    public GerenteView(LoginView parentFrame) {
        this.parentFrame = parentFrame; // Salva a referência
        initialize();

        // Adiciona o comportamento para reabrir a janela anterior ao fechar
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
        setTitle("Menu Gerente");
        setBounds(100, 100, 450, 550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas esta janela
        getContentPane().setLayout(null);

        JButton btnCadastrarCliente = new JButton("CLIENTE");
        btnCadastrarCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SelecionarClienteView selecionarClienteView = new SelecionarClienteView(GerenteView.this);
                selecionarClienteView.setVisible(true);

                GerenteView.this.setVisible(false);
            }
        });
        btnCadastrarCliente.setBounds(133, 56, 146, 46);
        getContentPane().add(btnCadastrarCliente);

        JButton btnCadastrarCompanhia = new JButton("COMPANHIA");
        btnCadastrarCompanhia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                SelecionarCompanhiaView selecionarCompanhiaView = new SelecionarCompanhiaView(GerenteView.this);
                selecionarCompanhiaView.setVisible(true);

                // Torna a janela atual invisível
                GerenteView.this.setVisible(false);

            }
        });
        btnCadastrarCompanhia.setBounds(133, 140, 146, 46);
        getContentPane().add(btnCadastrarCompanhia);

        JButton btnCadastrarModal = new JButton("MODAL");
        btnCadastrarModal.setBounds(133, 229, 146, 46);
        getContentPane().add(btnCadastrarModal);

        JButton btnCriarReserva = new JButton("RESERVA");
        btnCriarReserva.setBounds(133, 318, 146, 46);
        getContentPane().add(btnCriarReserva);

        JButton btnCadFunc = new JButton("Cadastrar Funcionário");
        btnCadFunc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirCadastroUsuario();
            }
        });
        btnCadFunc.setBounds(133, 406, 146, 46);
        getContentPane().add(btnCadFunc);

    }

    private void abrirCadastroUsuario() {
        CadastrarFuncionarioView telaCadastro = new CadastrarFuncionarioView(this);
        telaCadastro.setVisible(true);
        setVisible(false); // Oculta a tela atual
    }

}
