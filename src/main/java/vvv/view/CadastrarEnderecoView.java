package main.java.vvv.view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import main.java.vvv.dao.EnderecoDAO;
import main.java.vvv.dao.ExceptionDAO;
import main.java.vvv.model.Endereco;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrarEnderecoView extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JFrame frame;
    private JTextField textField_Logradouro;
    private JTextField textField_Numero;
    private JTextField textField_Pais;
    private JTextField textField_CodigoPostal;
    private JTextField textField_Longitude;
    private JTextField textField_Latitude;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CadastrarEnderecoView window = new CadastrarEnderecoView();
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
    public CadastrarEnderecoView() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        setBounds(100, 100, 450, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Cadastro de Endereço ");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(114, 29, 222, 59);
        getContentPane().add(lblNewLabel);

        JLabel lblVaivoltaViagens = new JLabel("Vai&Volta Viagens");
        lblVaivoltaViagens.setHorizontalAlignment(SwingConstants.CENTER);
        lblVaivoltaViagens.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblVaivoltaViagens.setBounds(114, 68, 222, 59);
        getContentPane().add(lblVaivoltaViagens);

        JLabel lblLogradouro = new JLabel("Logradouro");
        lblLogradouro.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblLogradouro.setBounds(55, 138, 101, 20);
        getContentPane().add(lblLogradouro);

        JLabel lblNumero = new JLabel("Número");
        lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNumero.setBounds(55, 208, 101, 20);
        getContentPane().add(lblNumero);

        JLabel lblPais = new JLabel("País");
        lblPais.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPais.setBounds(55, 276, 101, 20);
        getContentPane().add(lblPais);

        JLabel lblCodigoPostal = new JLabel("CEP");
        lblCodigoPostal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblCodigoPostal.setBounds(55, 346, 101, 20);
        getContentPane().add(lblCodigoPostal);

        JLabel lblLongitude = new JLabel("Longitude");
        lblLongitude.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblLongitude.setBounds(55, 411, 101, 20);
        getContentPane().add(lblLongitude);

        JLabel lblLatitude = new JLabel("Latitude");
        lblLatitude.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblLatitude.setBounds(55, 478, 101, 20);
        getContentPane().add(lblLatitude);

        textField_Logradouro = new JTextField();
        textField_Logradouro.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField_Logradouro.setBounds(55, 169, 330, 26);
        getContentPane().add(textField_Logradouro);
        textField_Logradouro.setColumns(10);

        textField_Numero = new JTextField();
        textField_Numero.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField_Numero.setColumns(10);
        textField_Numero.setBounds(55, 239, 75, 26);
        getContentPane().add(textField_Numero);

        textField_Pais = new JTextField();
        textField_Pais.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField_Pais.setColumns(10);
        textField_Pais.setBounds(55, 307, 167, 26);
        getContentPane().add(textField_Pais);

        textField_CodigoPostal = new JTextField();
        textField_CodigoPostal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField_CodigoPostal.setColumns(10);
        textField_CodigoPostal.setBounds(55, 377, 167, 26);
        getContentPane().add(textField_CodigoPostal);

        textField_Longitude = new JTextField();
        textField_Longitude.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField_Longitude.setColumns(10);
        textField_Longitude.setBounds(55, 441, 75, 26);
        getContentPane().add(textField_Longitude);

        textField_Latitude = new JTextField();
        textField_Latitude.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField_Latitude.setColumns(10);
        textField_Latitude.setBounds(55, 509, 75, 26);
        getContentPane().add(textField_Latitude);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String logradouro = textField_Logradouro.getText();
                String numeroTexto = textField_Numero.getText();
                String pais = textField_Pais.getText();
                String cep = textField_CodigoPostal.getText();
                String longitude = textField_Longitude.getText();
                String latitude = textField_Latitude.getText();


                if (logradouro.isEmpty() || numeroTexto.isEmpty() || pais.isEmpty() || cep.isEmpty() || longitude.isEmpty() || latitude.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int numero = Integer.parseInt(numeroTexto);

                Endereco endereco = new Endereco(logradouro, numero, pais, cep, longitude, latitude);


                EnderecoDAO enderecoDAO = new EnderecoDAO();
                boolean sucesso = false;
                try {
                    sucesso = enderecoDAO.cadastrarEndereco(endereco);
                } catch (ExceptionDAO e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

                if (sucesso) {
                    JOptionPane.showMessageDialog(null, "Endereço cadastrado com sucesso!");
                    textField_Logradouro.setText("");
                    textField_Numero.setText("");
                    textField_Pais.setText("");
                    textField_CodigoPostal.setText("");
                    textField_Longitude.setText("");
                    textField_Latitude.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar endereço!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnCadastrar.setBounds(254, 478, 131, 58);
        getContentPane().add(btnCadastrar);
    }
}