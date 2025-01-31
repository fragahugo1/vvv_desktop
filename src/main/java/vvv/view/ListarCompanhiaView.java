package main.java.vvv.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;

import main.java.vvv.controller.CompanhiaController;
import main.java.vvv.dao.CompanhiaDAO;
import main.java.vvv.model.Companhia;

public class ListarCompanhiaView extends JFrame {
    private JTextField textFieldNome;
    private JTextField textFieldIdDelete;
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

    private void initialize() {
        setTitle("Listagem de Companhia");
        setBounds(100, 100, 500, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        JLabel lblint = new JLabel("ID:");
        lblint.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblint.setBounds(100, 410, 100, 30);
        getContentPane().add(lblint);

        textFieldIdDelete = new JTextField();
        textFieldIdDelete.setBounds(160, 410, 200, 30);
        getContentPane().add(textFieldIdDelete);
        textFieldIdDelete.setColumns(10);

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
        CompanhiaController companhiaController = new CompanhiaController();
        List<Companhia> lista = companhiaController.listarCompanhias();

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
        long id = Long.parseLong(textFieldIdDelete.getText());

        CompanhiaController companhiaController = new CompanhiaController();
        boolean sucesso = companhiaController.deletarCompanhia(id);

        if (sucesso) {
            JOptionPane.showMessageDialog(this, "Companhia deletada com sucesso!");
            listarCompanhias(); // Atualiza a lista após a exclusão
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao deletar. Verifique se o nome está correto.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void atualizarCompanhia() {
        long id = Long.parseLong(textFieldId.getText());

        String novoNome = textFieldNome.getText();
        String novoCnpj = textFieldCnpj.getText();

        CompanhiaController companhiaController = new CompanhiaController();
        boolean sucesso = companhiaController.atualizarCompanhia(id, novoNome, novoCnpj);

        if (sucesso) {
            JOptionPane.showMessageDialog(this, "Companhia atualizada com sucesso!");
            listarCompanhias();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}