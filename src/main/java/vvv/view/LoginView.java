package main.java.vvv.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.font.ImageGraphicAttribute;
import java.awt.Image;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Label;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginView extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JTextField textField_1;
    /**
     * @wbp.nonvisual location=156,159
     */

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginView window = new LoginView();
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
    public LoginView() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        setTitle("Login");
        setBounds(100, 100, 450, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Login");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(83, 278, 59, 41);
        getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(152, 289, 174, 27);
        getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(152, 359, 174, 27);
        getContentPane().add(textField_1);

        JLabel lblSenha = new JLabel("Senha");
        lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblSenha.setBounds(83, 348, 59, 41);
        getContentPane().add(lblSenha);

        JButton btnLogin = new JButton("Avançar");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SelecionarView selecionarView = new SelecionarView(LoginView.this);
                selecionarView.setVisible(true);

                LoginView.this.setVisible(false);
            }
        });
        btnLogin.setBounds(148, 444, 129, 41);
        getContentPane().add(btnLogin);

        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\manager\\Downloads\\projetoTeste\\projetoTeste\\image\\vvv_desktop.png"));
        lblNewLabel_1.setBounds(83, 29, 302, 238);
        getContentPane().add(lblNewLabel_1);
    }
}

