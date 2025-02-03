package main.java.vvv.view;

import main.java.vvv.controller.EnderecoController;
import main.java.vvv.controller.LocalController;
import main.java.vvv.model.Endereco;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.*;

public class CadastrarLocalView extends JFrame {

    private SelecionarEnderecoView parentFrame;
    private EnderecoController enderecoController;
    private LocalController localController;
    private JTextField textFieldNome;
    private JList<String> listaEnderecos;
    private DefaultListModel<String> enderecoModel;
    private JComboBox<String> comboBoxTipoLocal;
    private List<Endereco> listaDeEnderecos;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CadastrarLocalView window = new CadastrarLocalView();
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public CadastrarLocalView() {
    	this.enderecoController = new EnderecoController();
        initialize();
        carregarEnderecos();
    }

    public CadastrarLocalView(SelecionarEnderecoView parentFrame) {
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
        setBounds(100, 100, 500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        setTitle("Cadastro de Local");
        setBounds(100, 100, 500, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().setLayout(null);

        JLabel lblTitulo = new JLabel("Cadastro de Local");
        lblTitulo.setBounds(100, 10, 300, 30);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(lblTitulo);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(50, 50, 100, 25);
        lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
        getContentPane().add(lblNome);

        textFieldNome = new JTextField();
        textFieldNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textFieldNome.setBounds(150, 50, 250, 25);
        getContentPane().add(textFieldNome);


        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(50, 86, 100, 25);
        lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        getContentPane().add(lblTipo);
        
        comboBoxTipoLocal = new JComboBox<>(new String[]{"Aeroporto", "Porto", "Rodoviária"});
        comboBoxTipoLocal.setBounds(150, 86, 150, 25);
        getContentPane().add(comboBoxTipoLocal);

        JLabel lblEndereco = new JLabel("Endereço:");
        lblEndereco.setBounds(50, 126, 100, 25);
        lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 14));
        getContentPane().add(lblEndereco);

        enderecoModel = new DefaultListModel<>();
        listaEnderecos = new JList<>(enderecoModel);
        JScrollPane scrollPane = new JScrollPane(listaEnderecos);
        scrollPane.setBounds(150, 126, 250, 100);
        getContentPane().add(scrollPane);
        
        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cadastrarLocal();
        	}
        });
        btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnCadastrar.setBounds(150, 252, 173, 66);
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
    
    private void cadastrarLocal() {

    	String nome = textFieldNome.getText();
        String tipo = comboBoxTipoLocal.getSelectedItem().toString();
        int indexEndereco = listaEnderecos.getSelectedIndex();
        int idEndereco = listaDeEnderecos.get(indexEndereco).getId();

        LocalController localController = new LocalController();
        boolean sucesso = localController.cadastrarLocal(nome,idEndereco,tipo);

        if (sucesso) {
            JOptionPane.showMessageDialog(this, "Local cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar local!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    	
    }
	
}
