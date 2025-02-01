package main.java.vvv.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.*;

import main.java.vvv.dao.CompanhiaDAO;
import main.java.vvv.model.Companhia;

public class ListarCompanhiaView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField textFieldNome;
    private JTextField textFieldId;
    private JTextField textFieldCnpj;
    private JTextArea textArea;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ListarCompanhiaView window = new ListarCompanhiaView();
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ListarCompanhiaView() {
        initialize();
    }

    public ListarCompanhiaView(SelecionarCompanhiaView parentFrame) {
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

        JLabel lblListagem = new JLabel("Listagem de Companhia");
        lblListagem.setHorizontalAlignment(SwingConstants.CENTER);
        lblListagem.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblListagem.setBounds(105, 60, 250, 30);
        getContentPane().add(lblListagem);

        JButton btnListar = new JButton("Listar");
        btnListar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnListar.setBounds(150, 100, 180, 40);
        btnListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarCompanhias();
            }
        });
        getContentPane().add(btnListar);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(50, 160, 400, 200);
        getContentPane().add(scrollPane);

        // Seção para Deletar Companhia
        JLabel lblDeletar = new JLabel("Deletar Companhia");
        lblDeletar.setHorizontalAlignment(SwingConstants.CENTER);
        lblDeletar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblDeletar.setBounds(105, 370, 250, 30);
        getContentPane().add(lblDeletar);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNome.setBounds(100, 410, 100, 30);
        getContentPane().add(lblNome);

        textFieldNome = new JTextField();
        textFieldNome.setBounds(160, 410, 200, 30);
        getContentPane().add(textFieldNome);
        textFieldNome.setColumns(10);

        JButton btnDeletar = new JButton("Deletar");
        btnDeletar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnDeletar.setBounds(180, 450, 140, 40);
        btnDeletar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deletarCompanhia();
            }
        });
        getContentPane().add(btnDeletar);

        // Seção para Atualizar Companhia
        JLabel lblUpdate = new JLabel("Update de Companhia");
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

        JLabel lblNovoCnpj = new JLabel("Novo CNPJ:");
        lblNovoCnpj.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNovoCnpj.setBounds(100, 620, 100, 30);
        getContentPane().add(lblNovoCnpj);

        textFieldCnpj = new JTextField();
        textFieldCnpj.setBounds(200, 620, 200, 30);
        getContentPane().add(textFieldCnpj);

        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnAtualizar.setBounds(180, 660, 140, 40);
        btnAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atualizarCompanhia();
            }
        });
        getContentPane().add(btnAtualizar);
    }

    private void listarCompanhias() {
        CompanhiaDAO dao = new CompanhiaDAO();
        List<Companhia> lista = dao.listarCompanhias();

        StringBuilder sb = new StringBuilder();
        sb.append("ID\tNome\tCNPJ\n");
        sb.append("------------------------------\n");

        for (Companhia c : lista) {
            sb.append(c.getId()).append("\t")
                    .append(c.getNome()).append("\t")
                    .append(c.getCnpj()).append("\n");
        }

        textArea.setText(sb.toString());
    }

    private void deletarCompanhia() {
        String nome = textFieldNome.getText().trim();
        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite um nome!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        CompanhiaDAO dao = new CompanhiaDAO();
        boolean sucesso = dao.deletarCompanhia(nome);

        if (sucesso) {
            JOptionPane.showMessageDialog(this, "Companhia deletada com sucesso!");
            listarCompanhias(); // Atualiza a lista após a exclusão
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao deletar. Verifique se o nome está correto.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void atualizarCompanhia() {
        int id = Integer.parseInt(textFieldId.getText());
        String novoNome = textFieldNome.getText();
        String novoCnpj = textFieldCnpj.getText();

        CompanhiaDAO dao = new CompanhiaDAO();
        boolean sucesso = dao.atualizarCompanhia(id, novoNome, novoCnpj);

        if (sucesso) {
            JOptionPane.showMessageDialog(this, "Companhia atualizada com sucesso!");
            listarCompanhias();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}