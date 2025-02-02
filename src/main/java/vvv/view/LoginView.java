package main.java.vvv.view;

import main.java.vvv.controller.UsuarioController;
import main.java.vvv.model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField textFieldLogin;
    private JPasswordField passwordField;

    public LoginView() {
        initialize();
    }

    private void initialize() {
        setTitle("Login");
        setBounds(100, 100, 450, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblLogin = new JLabel("Login");
        lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblLogin.setBounds(83, 278, 59, 41);
        getContentPane().add(lblLogin);

        textFieldLogin = new JTextField();
        textFieldLogin.setBounds(152, 289, 174, 27);
        getContentPane().add(textFieldLogin);
        textFieldLogin.setColumns(10);

        JLabel lblSenha = new JLabel("Senha");
        lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblSenha.setBounds(83, 348, 59, 41);
        getContentPane().add(lblSenha);

        passwordField = new JPasswordField();
        passwordField.setBounds(152, 359, 174, 27);
        getContentPane().add(passwordField);

        JButton btnLogin = new JButton("Avançar");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                autenticarUsuario();
            }
        });
        btnLogin.setBounds(148, 444, 129, 41);
        getContentPane().add(btnLogin);

        JLabel lblLogo = new JLabel("");
        lblLogo.setIcon(new ImageIcon("C:\\Users\\manager\\Downloads\\projetoTeste\\projetoTeste\\image\\vvv_desktop.png"));
        lblLogo.setBounds(83, 29, 302, 238);
        getContentPane().add(lblLogo);
    }

    private void autenticarUsuario() {
        String login = textFieldLogin.getText().trim();
        String senha = new String(passwordField.getPassword()).trim();

        if (login.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        UsuarioController usuarioController = new UsuarioController();
        Usuario usuario = usuarioController.autenticarUsuario(login, senha);

        if (usuario != null) {
            JOptionPane.showMessageDialog(this, "Login realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            abrirTelaCorrespondente(usuario.getNivel());
            dispose(); // Fecha a janela de login após sucesso
        } else {
            JOptionPane.showMessageDialog(this, "Usuário ou senha inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void abrirTelaCorrespondente(int nivel) {
        switch (nivel) {
            case 3:
                new DiretorView().setVisible(true);
                break;
            case 2:
                new GerenteView().setVisible(true);
                break;
            case 1:
                new FuncionarioView().setVisible(true);
                break;
            default:
                JOptionPane.showMessageDialog(this, "Nível de acesso desconhecido!", "Erro", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                LoginView window = new LoginView();
                window.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}