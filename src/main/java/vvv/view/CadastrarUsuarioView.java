package main.java.vvv.view;

import main.java.vvv.controller.LevelController;
import main.java.vvv.controller.UsuarioController;
import main.java.vvv.model.Level;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CadastrarUsuarioView extends JFrame {

    private JTextField textFieldLogin;
    private JTextField textFieldSenha;
    private DefaultListModel<String> levelModel;
    private JList<String> listLevels;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CadastrarUsuarioView window = new CadastrarUsuarioView();
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
    public CadastrarUsuarioView() {
        initialize();
        carregarLevels();
    }

    public CadastrarUsuarioView(JFrame parentFrame) {
        initialize();
        carregarLevels();
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


        setTitle("Cadastro de Usuário");
        setBounds(100, 100, 450, 550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Cadastro de Usuário ");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(114, 0, 222, 59);
        getContentPane().add(lblNewLabel);

        JLabel lblVaivoltaViagens = new JLabel("Vai&Volta Viagens");
        lblVaivoltaViagens.setHorizontalAlignment(SwingConstants.CENTER);
        lblVaivoltaViagens.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblVaivoltaViagens.setBounds(114, 11, 222, 114);
        getContentPane().add(lblVaivoltaViagens);

        JLabel lblNome = new JLabel("Login");
        lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNome.setBounds(85, 108, 71, 30);
        getContentPane().add(lblNome);

        textFieldLogin = new JTextField();
        textFieldLogin.setBounds(95, 149, 259, 30);
        getContentPane().add(textFieldLogin);
        textFieldLogin.setColumns(10);

        JLabel lblCPF = new JLabel("Senha");
        lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblCPF.setBounds(85, 190, 71, 30);
        getContentPane().add(lblCPF);

        textFieldSenha = new JTextField();
        textFieldSenha.setColumns(10);
        textFieldSenha.setBounds(95, 231, 259, 30);
        getContentPane().add(textFieldSenha);

        JLabel lblCliente = new JLabel("Level");
        lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblCliente.setBounds(85, 285, 71, 30);
        getContentPane().add(lblCliente);

        levelModel = new DefaultListModel<>();
        listLevels = new JList<>(levelModel);

        // Adicionando a JList dentro de um JScrollPane
        JScrollPane scrollPaneLevels = new JScrollPane(listLevels);
        scrollPaneLevels.setBounds(95, 320, 259, 80);
        getContentPane().add(scrollPaneLevels);

        JButton btnCadastro = new JButton("Cadastrar");
        btnCadastro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarUsuario();
            }
        });
        btnCadastro.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnCadastro.setBounds(155, 428, 124, 53);
        getContentPane().add(btnCadastro);

    }

    private void carregarLevels() {
        LevelController levelController = new LevelController();
        List<Level> levels = levelController.listarLevel();

        levelModel.clear();

        if (levels != null) {
            for (Level c : levels) {
                levelModel.addElement(c.getId() + " - " + c.getTipo());
            }
        } else {
            System.out.println("Erro ao carregar níveis.");
        }
    }

    private int getIdLevelSelecionado() {
        String selecionado = listLevels.getSelectedValue();
        if (selecionado != null) {
            return Integer.parseInt(selecionado.split(" - ")[0]);
        }
        return -1;
    }

    private void cadastrarUsuario() {
        String login = textFieldLogin.getText().trim();
        String senha = textFieldSenha.getText().trim();
        int idLevel = getIdLevelSelecionado();

        if (login.isEmpty() || senha.isEmpty() || idLevel == -1) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos e selecione um nível!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        UsuarioController usuarioController = new UsuarioController();
        boolean sucesso = usuarioController.cadastrarUsuario(login, senha, idLevel);

        if (sucesso) {
            JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            dispose(); // Fecha a janela após o cadastro
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar usuário!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
