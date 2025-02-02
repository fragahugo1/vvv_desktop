package main.java.vvv.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class SelecionarCompanhiaView extends JFrame {

    private static final long serialVersionUID = 1L;
    private FuncionarioView parentFrame;
    private GerenteView parentGerenteFrame;
    private DiretorView parentDiretorFrame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FuncionarioView funcionarioView = new FuncionarioView(); // Criando a janela anterior
                    funcionarioView.setVisible(true);

                    SelecionarCompanhiaView window = new SelecionarCompanhiaView();
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
    public SelecionarCompanhiaView() {initialize();}

    public SelecionarCompanhiaView(FuncionarioView parentFrame) {
        this.parentFrame = parentFrame;
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

    public SelecionarCompanhiaView(GerenteView parentFrame) {
        this.parentGerenteFrame = parentFrame;
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

    public SelecionarCompanhiaView(DiretorView parentFrame) {
        this.parentDiretorFrame = parentFrame;
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

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        setBounds(100, 100, 450, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        JButton btnCadComp = new JButton("Cadastrar Companhia");
        btnCadComp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadastrarCompanhiaView cadastrarCompanhiaView = new CadastrarCompanhiaView(SelecionarCompanhiaView.this);
                cadastrarCompanhiaView.setVisible(true);

                SelecionarCompanhiaView.this.setVisible(false);
            }
        });
        btnCadComp.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnCadComp.setBounds(108, 60, 206, 69);
        getContentPane().add(btnCadComp);

        JButton btnListarComp = new JButton("Atualizar/Deletar/Listar");
        btnListarComp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ListarCompanhiaView listarCompanhiaView = new ListarCompanhiaView(SelecionarCompanhiaView.this);
                listarCompanhiaView.setVisible(true);

                SelecionarCompanhiaView.this.setVisible(false);
            }
        });
        btnListarComp.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnListarComp.setBounds(108, 180, 206, 69);
        getContentPane().add(btnListarComp);
    }

}