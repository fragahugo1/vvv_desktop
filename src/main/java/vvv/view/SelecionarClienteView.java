package main.java.vvv.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SelecionarClienteView extends JFrame {

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SelecionarClienteView window = new SelecionarClienteView();
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
    public SelecionarClienteView() {
        initialize();
    }

    public SelecionarClienteView(FuncionarioView parentFrame) {
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

    public SelecionarClienteView(GerenteView parentFrame) {
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

    public SelecionarClienteView(DiretorView parentFrame) {
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

        setBounds(100, 100, 450, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        JButton btnCadCliente = new JButton("Cadastrar Cliente");
        btnCadCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadastrarClienteView cadastrarClienteView = new CadastrarClienteView(SelecionarClienteView.this);
                cadastrarClienteView.setVisible(true);

                SelecionarClienteView.this.setVisible(false);
            }
        });
        btnCadCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnCadCliente.setBounds(108, 60, 206, 69);
        getContentPane().add(btnCadCliente);

        JButton btnCadPass = new JButton("Cadastrar Passageiro");
        btnCadPass.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadastrarPassageiroView cadastrarPassageiroView = new CadastrarPassageiroView(SelecionarClienteView.this);
                cadastrarPassageiroView.setVisible(true);

                SelecionarClienteView.this.setVisible(false);
            }
        });
        btnCadPass.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnCadPass.setBounds(108, 180, 206, 69);
        getContentPane().add(btnCadPass);
    }

}