package main.java.vvv.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import main.java.vvv.controller.CompanhiaController;
import main.java.vvv.model.Companhia;

public class CadastrarCompanhiaView extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CadastrarCompanhiaView window = new CadastrarCompanhiaView();
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public CadastrarCompanhiaView() {
        initialize();
    }

    public CadastrarCompanhiaView(SelecionarView parentFrame) {
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
     * Create the application.
     */

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        setTitle("Cadastro de Companhia");
        setBounds(100, 100, 450, 365);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas esta janela
        getContentPane().setLayout(null);


        JLabel lblNewLabel = new JLabel("Cadastro de Companhia ");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(114, 29, 222, 59);
        getContentPane().add(lblNewLabel);

        JLabel lblVaivoltaViagens = new JLabel("Vai&Volta Viagens");
        lblVaivoltaViagens.setHorizontalAlignment(SwingConstants.CENTER);
        lblVaivoltaViagens.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblVaivoltaViagens.setBounds(114, 68, 222, 59);
        getContentPane().add(lblVaivoltaViagens);

        JLabel lblNewLabel_1 = new JLabel("Nome");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(65, 145, 46, 14);
        getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("CNPJ");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1_1.setBounds(65, 198, 46, 14);
        getContentPane().add(lblNewLabel_1_1);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textField.setBounds(132, 138, 222, 33);
        getContentPane().add(textField);
        textField.setColumns(10);

        JFormattedTextField formattedTextField = new JFormattedTextField();
        formattedTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        formattedTextField.setBounds(132, 191, 222, 33);
        getContentPane().add(formattedTextField);

        JButton btnNewButton = new JButton("Confirmar");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = textField.getText();
                String cnpj = formattedTextField.getText();

                if (nome.isEmpty() || cnpj.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // cria objeto Companhia
                Companhia companhia = new Companhia(nome, cnpj);

                // chama a controller para cadastrar
                CompanhiaController companhiaController = new CompanhiaController();
                boolean sucesso = false;
                try {
                    sucesso = companhiaController.cadastrarCompanhia(nome, cnpj);
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

                if (sucesso) {
                    JOptionPane.showMessageDialog(null, "Companhia cadastrada com sucesso!");
                    textField.setText(""); // Limpar o campo de texto
                    formattedTextField.setText(""); // Limpar o campo de CNPJ
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar companhia!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton.setBounds(154, 252, 121, 38);
        getContentPane().add(btnNewButton);
    }
}

