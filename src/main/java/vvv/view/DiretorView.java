package main.java.vvv.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DiretorView extends JFrame {

    private static final long serialVersionUID = 1L;
    private LoginView parentFrame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DiretorView window = new DiretorView();
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
    public DiretorView() {
        initialize();
    }

    public DiretorView(LoginView parentFrame) {
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
        setTitle("Menu Diretor");
        setBounds(100, 100, 450, 550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas esta janela
        getContentPane().setLayout(null);

        JButton btnCadastrarCliente = new JButton("CLIENTE");
        btnCadastrarCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SelecionarClienteView selecionarClienteView = new SelecionarClienteView(DiretorView.this);
                selecionarClienteView.setVisible(true);

                DiretorView.this.setVisible(false);
            }
        });
        btnCadastrarCliente.setBounds(133, 52, 146, 46);
        getContentPane().add(btnCadastrarCliente);

        JButton btnCadastrarCompanhia = new JButton("COMPANHIA");
        btnCadastrarCompanhia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                SelecionarCompanhiaView selecionarCompanhiaView = new SelecionarCompanhiaView(DiretorView.this);
                selecionarCompanhiaView.setVisible(true);

                // Torna a janela atual invisível
                DiretorView.this.setVisible(false);

            }
        });
        btnCadastrarCompanhia.setBounds(133, 136, 146, 46);
        getContentPane().add(btnCadastrarCompanhia);

        JButton btnCadastrarModal = new JButton("MODAL");
        btnCadastrarModal.setBounds(133, 225, 146, 46);
        getContentPane().add(btnCadastrarModal);

        JButton btnCriarReserva = new JButton("RESERVA");
        btnCriarReserva.setBounds(133, 314, 146, 46);
        getContentPane().add(btnCriarReserva);

        JButton btnCadUsr = new JButton("Cadastrar Usuário");
        btnCadUsr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirCadastroUsuario();
            }
        });
        btnCadUsr.setBounds(133, 400, 146, 46);
        getContentPane().add(btnCadUsr);

    }

    private void abrirCadastroUsuario() {
        CadastrarUsuarioView telaCadastro = new CadastrarUsuarioView(this);
        telaCadastro.setVisible(true);
        setVisible(false); // Oculta a tela atual
    }
}
