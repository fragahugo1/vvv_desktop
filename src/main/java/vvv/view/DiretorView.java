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
        btnCadastrarCliente.setBounds(133, 45, 146, 46);
        getContentPane().add(btnCadastrarCliente);
        
        JButton btnEnderecos = new JButton("ENDEREÇOS");
        btnEnderecos.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		SelecionarEnderecoView selecionarEnderecoView = new SelecionarEnderecoView(DiretorView.this);
        		selecionarEnderecoView.setVisible(true);
        		
        		DiretorView.this.setVisible(false);
        	}
        });
        btnEnderecos.setBounds(133, 111, 146, 46);
        getContentPane().add(btnEnderecos);

        JButton btnCadastrarCompanhia = new JButton("COMPANHIA");
        btnCadastrarCompanhia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                SelecionarCompanhiaView selecionarCompanhiaView = new SelecionarCompanhiaView(DiretorView.this);
                selecionarCompanhiaView.setVisible(true);

                // Torna a janela atual invisível
                DiretorView.this.setVisible(false);

            }
        });
        btnCadastrarCompanhia.setBounds(133, 184, 146, 46);
        getContentPane().add(btnCadastrarCompanhia);

        JButton btnCadastrarModal = new JButton("MODAL");
        btnCadastrarModal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SelecionarModalView selecionarModalView = new SelecionarModalView(DiretorView.this);
                selecionarModalView.setVisible(true);

                DiretorView.this.setVisible(false);
            }
        });
        btnCadastrarModal.setBounds(133, 249, 146, 46);
        getContentPane().add(btnCadastrarModal);

        JButton btnCriarReserva = new JButton("RESERVA");
        btnCriarReserva.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SelecionarReservaView selecionarReservaView = new SelecionarReservaView(DiretorView.this);
                selecionarReservaView.setVisible(true);

                DiretorView.this.setVisible(false);
            }
        });
        btnCriarReserva.setBounds(133, 319, 146, 46);
        getContentPane().add(btnCriarReserva);

        JButton btnCadUsr = new JButton("Cadastrar Usuário");
        btnCadUsr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	CadastrarUsuarioView telaCadastro = new CadastrarUsuarioView(DiretorView.this);
                telaCadastro.setVisible(true);
                
                DiretorView.this.setVisible(false);
            }
        });
        btnCadUsr.setBounds(133, 386, 146, 46);
        getContentPane().add(btnCadUsr);
        

    }
}
