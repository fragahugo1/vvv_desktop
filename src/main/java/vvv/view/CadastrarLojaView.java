package main.java.vvv.view;

import main.java.vvv.controller.EnderecoController;
import main.java.vvv.controller.LojaController;
import main.java.vvv.model.Endereco;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class CadastrarLojaView extends JFrame {

    private SelecionarEnderecoView parentFrame;
    private JTextField textFieldNome;
    private JTextField textFieldCNPJ;
    private JList<String> listaEnderecos;
    private DefaultListModel<String> enderecoModel;
    private EnderecoController enderecoController;
    private LojaController lojaController;
    private JComboBox<String> comboBoxTipoLoja;
    private List<Endereco> listaDeEnderecos;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CadastrarLojaView window = new CadastrarLojaView();
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public CadastrarLojaView() {
        initialize();
         
    }

    public CadastrarLojaView(SelecionarEnderecoView parentFrame) {
        this.parentFrame = parentFrame;
        enderecoController = new EnderecoController();
        initialize();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (parentFrame != null) {
                    parentFrame.setVisible(true);
                }
            }
        });
    }

    private void initialize() {
        setTitle("Cadastro de Loja");
        setBounds(100, 100, 500, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblTitulo = new JLabel("Cadastro de Loja");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(100, 10, 300, 30);
        getContentPane().add(lblTitulo);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNome.setBounds(50, 50, 100, 25);
        getContentPane().add(lblNome);

        textFieldNome = new JTextField();
        textFieldNome.setBounds(150, 50, 250, 25);
        getContentPane().add(textFieldNome);

        JLabel lblCNPJ = new JLabel("CNPJ:");
        lblCNPJ.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblCNPJ.setBounds(50, 90, 100, 25);
        getContentPane().add(lblCNPJ);

        textFieldCNPJ = new JTextField();
        textFieldCNPJ.setBounds(150, 90, 250, 25);
        getContentPane().add(textFieldCNPJ);

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblTipo.setBounds(50, 130, 100, 25);
        getContentPane().add(lblTipo);

        // Criando JComboBox para escolha do tipo da loja
        comboBoxTipoLoja = new JComboBox<>(new String[]{"Física", "Virtual"});
        comboBoxTipoLoja.setBounds(150, 132, 150, 25);
        getContentPane().add(comboBoxTipoLoja);


        JLabel lblEndereco = new JLabel("Endereço:");
        lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblEndereco.setBounds(50, 170, 100, 25);
        getContentPane().add(lblEndereco);

        enderecoModel = new DefaultListModel<>();
        listaEnderecos = new JList<>(enderecoModel);
        JScrollPane scrollPane = new JScrollPane(listaEnderecos);
        scrollPane.setBounds(150, 170, 250, 100);
        getContentPane().add(scrollPane);

        comboBoxTipoLoja.addActionListener(e -> {
            if (comboBoxTipoLoja.getSelectedItem().equals("Virtual")) {
                listaEnderecos.setEnabled(false);
                scrollPane.setEnabled(false);
            } else {
                listaEnderecos.setEnabled(true);
                scrollPane.setEnabled(true);
            }
        });

        JButton btnCadastrar = new JButton("Cadastrar Loja");
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarLoja();
            }
        });
        btnCadastrar.setBounds(150, 300, 150, 40);
        getContentPane().add(btnCadastrar);


    }

    private void carregarEnderecos() {
        if (enderecoController == null) {
            System.err.println("Erro: enderecoController não foi inicializado!");
            return;
        }

        listaDeEnderecos = enderecoController.listarEnderecos();
        enderecoModel.clear();
        for (Endereco e : listaDeEnderecos) {
            enderecoModel.addElement(e.getRua() + ", " + e.getNumero() + " - " + e.getPais());
        }
    }

    private void cadastrarLoja() {
        String nome = textFieldNome.getText().trim();
        String cnpj = textFieldCNPJ.getText().trim();
        boolean tipoLoja = comboBoxTipoLoja.getSelectedItem().equals("Virtual");

        Integer idEndereco = null; // Inicializamos como null

        int indexEndereco = listaEnderecos.getSelectedIndex();
        if (!tipoLoja && indexEndereco >= 0) {  // Se for física, pega o endereço
            idEndereco = listaDeEnderecos.get(indexEndereco).getId();
        }

        // Validação de campos
        if (nome.isEmpty() || cnpj.isEmpty() || (!tipoLoja && idEndereco == null)) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos corretamente!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Chama o controller para cadastrar
        LojaController lojaController = new LojaController();
        boolean sucesso = lojaController.cadastrarLoja(nome, cnpj, tipoLoja, idEndereco);

        if (sucesso) {
            JOptionPane.showMessageDialog(this, "Loja cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar loja!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}