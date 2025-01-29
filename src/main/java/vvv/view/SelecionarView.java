package main.java.vvv.view;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class SelecionarView extends JFrame {


    private static final long serialVersionUID = 1L;
    private LoginView parentFrame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SelecionarView window = new SelecionarView();
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
    public SelecionarView() {
        initialize();
    }

    public SelecionarView(LoginView parentFrame) {
        this.parentFrame = parentFrame; // Salva a referência
        initialize();

        // Adiciona o comportamento para reabrir a janela anterior ao fechar
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
        setTitle("Menu");
        setBounds(100, 100, 450, 550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas esta janela
        getContentPane().setLayout(null);

        JButton btnNewButton = new JButton("Cadastrar Modal");
        btnNewButton.setBounds(133, 76, 146, 46);
        getContentPane().add(btnNewButton);

        JButton btnCadastrarCompanhia = new JButton("Cadastrar Companhia");
        btnCadastrarCompanhia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                CadastrarCompanhiaView cadastrarCompanhiaView = new CadastrarCompanhiaView(SelecionarView.this);
                cadastrarCompanhiaView.setVisible(true);

                // Torna a janela atual invisível
                SelecionarView.this.setVisible(false);

            }
        });
        btnCadastrarCompanhia.setBounds(133, 160, 146, 46);
        getContentPane().add(btnCadastrarCompanhia);

        JButton btnCadastrarCliente = new JButton("Cadastrar Cliente");
        btnCadastrarCliente.setBounds(133, 249, 146, 46);
        getContentPane().add(btnCadastrarCliente);

        JButton btnCriarReserva = new JButton("Criar Reserva");
        btnCriarReserva.setBounds(133, 338, 146, 46);
        getContentPane().add(btnCriarReserva);
    }

}

