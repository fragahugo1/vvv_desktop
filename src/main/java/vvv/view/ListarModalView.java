package main.java.vvv.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import main.java.vvv.controller.ModalController;
import main.java.vvv.dao.CompanhiaDAO;
import main.java.vvv.model.Modal;

public class ListarModalView extends JFrame {

	private static final long serialVersionUID = 1L;
    private JTextField textFieldNome;
    private JTextField textFieldIdDelete;
    private JTextField textFieldId;
    private JTextField textFieldCnpj;
    private JTextArea textArea;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ListarModalView window = new ListarModalView();
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ListarModalView() {
        initialize();
    }

    public ListarModalView(SelecionarModalView parentFrame) {
        initialize();
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
        setTitle("Listagem de Companhia");
        setBounds(100, 100, 500, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblTitulo = new JLabel("Vai&Volta Viagens");
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(105, 20, 250, 40);
        getContentPane().add(lblTitulo);

        JLabel lblListagem = new JLabel("Listagem de Modais");
        lblListagem.setHorizontalAlignment(SwingConstants.CENTER);
        lblListagem.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblListagem.setBounds(105, 60, 250, 30);
        getContentPane().add(lblListagem);

        JButton btnListar = new JButton("Listar");
        btnListar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnListar.setBounds(150, 100, 180, 40);
        btnListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarModais();
            }
        });
        getContentPane().add(btnListar);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(50, 160, 400, 200);
        getContentPane().add(scrollPane);

        
        JLabel lblDeletar = new JLabel("Deletar Modal");
        lblDeletar.setHorizontalAlignment(SwingConstants.CENTER);
        lblDeletar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblDeletar.setBounds(105, 370, 250, 30);
        getContentPane().add(lblDeletar);

        JLabel lblIdDelete = new JLabel("ID:");
        lblIdDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblIdDelete.setBounds(100, 410, 100, 30);
        getContentPane().add(lblIdDelete);

        textFieldIdDelete = new JTextField();
        textFieldIdDelete.setBounds(160, 410, 200, 30);
        getContentPane().add(textFieldIdDelete);
        textFieldIdDelete.setColumns(10);

        JButton btnDeletar = new JButton("Deletar");
        btnDeletar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnDeletar.setBounds(180, 450, 140, 40);
        btnDeletar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deletarModal();
            }
        });
        getContentPane().add(btnDeletar);

        // Seção para Atualizar Companhia
        JLabel lblUpdate = new JLabel("Update de Modal");
        lblUpdate.setHorizontalAlignment(SwingConstants.CENTER);
        lblUpdate.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblUpdate.setBounds(105, 500, 250, 30);
        getContentPane().add(lblUpdate);

        JLabel lblId = new JLabel("ID:");
        lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblId.setBounds(100, 540, 100, 30);
        getContentPane().add(lblId);

        textFieldId = new JTextField();
        textFieldId.setBounds(200, 540, 200, 30);
        getContentPane().add(textFieldId);

        JLabel lblNovoNome = new JLabel("Novo Nome:");
        lblNovoNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNovoNome.setBounds(100, 580, 100, 30);
        getContentPane().add(lblNovoNome);

        textFieldNome = new JTextField();
        textFieldNome.setBounds(200, 580, 200, 30);
        getContentPane().add(textFieldNome);

        JLabel lblNovaCapacidade = new JLabel("Nova Capacidade:");
        lblNovaCapacidade.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNovaCapacidade.setBounds(100, 620, 127, 30);
        getContentPane().add(lblNovaCapacidade);

        textFieldCnpj = new JTextField();
        textFieldCnpj.setBounds(237, 620, 163, 30);
        getContentPane().add(textFieldCnpj);

        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnAtualizar.setBounds(180, 660, 140, 40);
        btnAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atualizarModal();
            }
        });
        getContentPane().add(btnAtualizar);
    }

    private void listarModais() {
        ModalController controller = new ModalController();
        List<Modal> lista = controller.listarModal();

        StringBuilder sb = new StringBuilder();
        sb.append("ID\tNome\tCapacidade\tDt Fabricação\tTipo\n");
        sb.append("--------------------------------------------------------------------------------------------------------------\n");

        for (Modal c : lista) {
            sb.append(c.getId()).append("\t")
                    .append(c.getNome()).append("\t")
                    .append(c.getCapacidade()).append("\t")
                    .append(c.getDataFabricacao()).append("\t")
                    .append(c.getTipo()).append("\n");
        }

        textArea.setText(sb.toString());
    }

    private void deletarModal() {
        int id = Integer.parseInt(textFieldIdDelete.getText().trim());
        if (id <= 0) {
            JOptionPane.showMessageDialog(this, "Digite um ID válido!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ModalController controller = new ModalController();
        boolean sucesso = controller.deletarModal(id);

        if (sucesso) {
            JOptionPane.showMessageDialog(this, "Modal deletado com sucesso!");
            listarModais(); // Atualiza a lista após a exclusão
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao deletar. Verifique se o ID está correto.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void atualizarModal() {
        int id = Integer.parseInt(textFieldId.getText());
        String novoNome = textFieldNome.getText();
        int novoCapacidade = Integer.parseInt(textFieldCnpj.getText());

        ModalController controller = new ModalController();
        boolean sucesso = controller.atualizarModal(id, novoNome, novoCapacidade);

        if (sucesso) {
            JOptionPane.showMessageDialog(this, "Companhia atualizada com sucesso!");
            listarModais();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
