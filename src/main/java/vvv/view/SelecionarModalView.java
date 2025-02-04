package main.java.vvv.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;


public class SelecionarModalView extends JFrame {

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

                    SelecionarModalView window = new SelecionarModalView();
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
    public SelecionarModalView() {initialize();}

    public SelecionarModalView(FuncionarioView parentFrame) {
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

    public SelecionarModalView(GerenteView parentFrame) {
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

    public SelecionarModalView(DiretorView parentFrame) {
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

        JButton btnCadModal = new JButton("Cadastrar Modal");
        btnCadModal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadastrarModalView cadastrarModalView = new CadastrarModalView(SelecionarModalView.this);
                cadastrarModalView.setVisible(true);

                //SelecionarModalView.this.setVisible(false);
            }
        });
        btnCadModal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnCadModal.setBounds(108, 60, 206, 69);
        getContentPane().add(btnCadModal);

        JButton btnListarComp = new JButton("Atualizar/Deletar/Listar");
        btnListarComp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ListarModalView listarModalView = new ListarModalView(SelecionarModalView.this);
                listarModalView.setVisible(true);

                //SelecionarModalView.this.setVisible(false);
            }
        });
        btnListarComp.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnListarComp.setBounds(108, 180, 206, 69);
        getContentPane().add(btnListarComp);
    }
}
