package main.java.vvv.view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CadastrarModalView extends JFrame{
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CadastrarModalView window = new CadastrarModalView();
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
    public CadastrarModalView() {
        setTitle("Cadastro de Modal");
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        setBounds(100, 100, 450, 880);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Cadastro de Modal");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(106, 29, 222, 59);
        getContentPane().add(lblNewLabel);

        JLabel lblVaivoltaViagens = new JLabel("Vai&Volta Viagens");
        lblVaivoltaViagens.setHorizontalAlignment(SwingConstants.CENTER);
        lblVaivoltaViagens.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblVaivoltaViagens.setBounds(106, 61, 222, 78);
        getContentPane().add(lblVaivoltaViagens);

        JLabel lblNewLabel_1 = new JLabel("Capacidade");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1.setBounds(59, 163, 116, 31);
        getContentPane().add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(59, 204, 116, 31);
        getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(59, 299, 116, 31);
        getContentPane().add(textField_1);

        JLabel lblNewLabel_1_1 = new JLabel("Data de Fabricação");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1_1.setBounds(59, 258, 180, 31);
        getContentPane().add(lblNewLabel_1_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(59, 396, 116, 31);
        getContentPane().add(textField_2);

        JLabel lblNewLabel_1_2 = new JLabel("Companhia");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1_2.setBounds(59, 355, 116, 31);
        getContentPane().add(lblNewLabel_1_2);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(59, 499, 116, 31);
        getContentPane().add(textField_3);

        JLabel lblNewLabel_1_3 = new JLabel("Local de Partida");
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1_3.setBounds(59, 458, 116, 31);
        getContentPane().add(lblNewLabel_1_3);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(59, 597, 116, 31);
        getContentPane().add(textField_4);

        JLabel lblNewLabel_1_4 = new JLabel("Local de Chegada");
        lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1_4.setBounds(59, 556, 161, 31);
        getContentPane().add(lblNewLabel_1_4);

        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(59, 701, 116, 31);
        getContentPane().add(textField_5);

        JLabel lblNewLabel_1_5 = new JLabel("Tipo de Modal");
        lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1_5.setBounds(59, 660, 116, 31);
        getContentPane().add(lblNewLabel_1_5);

        JButton btnNewButton = new JButton("Cadastrar");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnNewButton.setBounds(244, 695, 137, 39);
        getContentPane().add(btnNewButton);
    }

}
