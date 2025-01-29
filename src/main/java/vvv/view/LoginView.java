package main.java.vvv.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginView {

    private JFrame frmLoginview;
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
                    window.frmLoginview.setVisible(true);
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
        frmLoginview = new JFrame();
        frmLoginview.setTitle("Login");
        frmLoginview.setBounds(100, 100, 450, 550);
        frmLoginview.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmLoginview.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Login");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(83, 278, 59, 41);
        frmLoginview.getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(152, 289, 174, 27);
        frmLoginview.getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(152, 359, 174, 27);
        frmLoginview.getContentPane().add(textField_1);

        JLabel lblSenha = new JLabel("Senha");
        lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblSenha.setBounds(83, 348, 59, 41);
        frmLoginview.getContentPane().add(lblSenha);

        JButton btnNewButton = new JButton("Avançar");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SelecionarView selecionarView = new SelecionarView();
                selecionarView.setVisible(true);
            }
        });
        btnNewButton.setBounds(148, 444, 129, 41);
        frmLoginview.getContentPane().add(btnNewButton);

        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon("image/vvv_desktop.webp"));
        lblNewLabel_1.setBounds(83, 29, 302, 238);
        frmLoginview.getContentPane().add(lblNewLabel_1);
    }
}
