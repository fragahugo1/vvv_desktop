package main.java.vvv.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.*;

import main.java.vvv.controller.CompanhiaController;
import main.java.vvv.controller.ModalController;
import main.java.vvv.model.Companhia;
import main.java.vvv.model.Endereco;

public class CadastrarModalView extends JFrame {

    private SelecionarModalView parentFrame;
    private JTextField textFieldNome;
    private JComboBox<String> comboBoxTipoModal; 
    private DefaultListModel<String> companhiaModel;
    private JList<String> listaCompanhia;
    private List<Companhia> listaDeCompanhias;
    private int idCompanhiaSelecionada = -1; // Armazena o ID da companhia selecionada
    private JTextField textFieldCapacidade;
    private JTextField textFieldDtFab;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                CadastrarModalView window = new CadastrarModalView();
                window.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public CadastrarModalView() {
        initialize();
        carregarCompanhias(); 
    }

    public CadastrarModalView(SelecionarModalView parentFrame) {
        this.parentFrame = parentFrame;
        initialize();
        carregarCompanhias();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (parentFrame != null) {
                    parentFrame.setVisible(true); // Torna a janela anterior visível novamente
                }
            }
        });
    }
    

    private void initialize() {
        setBounds(100, 100, 500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        
        JLabel lblTitulo = new JLabel("Cadastro de Modal");
        lblTitulo.setBounds(10, 11, 424, 25);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(lblTitulo);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(60, 61, 100, 25);
        lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
        getContentPane().add(lblNome);

        textFieldNome = new JTextField();
        textFieldNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textFieldNome.setBounds(192, 61, 200, 25);
        getContentPane().add(textFieldNome);

        JLabel lblCapacidade = new JLabel("Capacidade:");
        lblCapacidade.setBounds(60, 97, 100, 25);
        lblCapacidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
        getContentPane().add(lblCapacidade);

        textFieldCapacidade = new JTextField();
        textFieldCapacidade.setBounds(192, 97, 63, 25);
        getContentPane().add(textFieldCapacidade);
        textFieldCapacidade.setColumns(10);

        JLabel lblDtFab = new JLabel("Data de Fabricação:");
        lblDtFab.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblDtFab.setBounds(60, 133, 122, 25);
        getContentPane().add(lblDtFab);

        textFieldDtFab = new JTextField();
        textFieldDtFab.setColumns(10);
        textFieldDtFab.setBounds(192, 133, 86, 25);
        getContentPane().add(textFieldDtFab);

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(60, 169, 100, 25);
        lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        getContentPane().add(lblTipo);

        comboBoxTipoModal = new JComboBox<>(new String[]{"Avião", "Trem", "Ônibus", "Navio"});
        comboBoxTipoModal.setBounds(192, 169, 150, 25);
        getContentPane().add(comboBoxTipoModal);

        JLabel lblCompanhia = new JLabel("Companhia:");
        lblCompanhia.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblCompanhia.setBounds(60, 205, 100, 25);
        getContentPane().add(lblCompanhia);

        // Criar a lista de companhias
        companhiaModel = new DefaultListModel<>();
        listaCompanhia = new JList<>(companhiaModel);
        listaCompanhia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // ScrollPane para a lista de companhias
        JScrollPane scrollPane = new JScrollPane(listaCompanhia);
        scrollPane.setBounds(192, 205, 200, 80);
        getContentPane().add(scrollPane);

        // Adicionar listener para capturar o ID da companhia selecionada
        listaCompanhia.addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting() && listaCompanhia.getSelectedIndex() != -1) {
                String selectedValue = listaCompanhia.getSelectedValue();
                idCompanhiaSelecionada = Integer.parseInt(selectedValue.split(" - ")[0]); // Captura o ID
            }
        });

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarModal();
            }
        });
        btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnCadastrar.setBounds(150, 322, 161, 53);
        getContentPane().add(btnCadastrar);
    }

    private void carregarCompanhias() {
        CompanhiaController companhiaController = new CompanhiaController();
        List<Companhia> lista = companhiaController.listarCompanhias();
        
        listaDeCompanhias = companhiaController.listarCompanhias();
        companhiaModel.clear();
        for (Companhia companhia : lista) {
            companhiaModel.addElement(companhia.getId() + " - " + companhia.getNome());
        }
    }
    
    public void cadastrarModal() {
    	
    	if (idCompanhiaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione uma companhia!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nome = textFieldNome.getText();
        int capacidade = Integer.parseInt(textFieldCapacidade.getText());
        String dtFabricacao = textFieldDtFab.getText();
        String tipo = (String) comboBoxTipoModal.getSelectedItem();
        int indexCompanhia = listaCompanhia.getSelectedIndex();
        long idCompanhia = listaDeCompanhias.get(indexCompanhia).getId();
        
        Date dtFabricacaoStr = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date parsedDate = sdf.parse(dtFabricacao);
            dtFabricacaoStr = new Date(parsedDate.getTime()); // Convertendo para java.sql.Date
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Data de fabricação inválida! Use o formato dd/MM/yyyy.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        ModalController modalController = new ModalController();
        boolean sucesso = modalController.cadastrarModal(nome, capacidade, dtFabricacaoStr, tipo, idCompanhia); 
        if (sucesso) {
            JOptionPane.showMessageDialog(this, "Modal cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar modal!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}