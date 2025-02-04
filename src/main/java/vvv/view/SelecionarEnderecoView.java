package main.java.vvv.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SelecionarEnderecoView extends JFrame {
	/**
	 * 
	 */
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
					SelecionarEnderecoView window = new SelecionarEnderecoView();
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
	public SelecionarEnderecoView() {
		
		initialize();
	}
	
	public SelecionarEnderecoView(FuncionarioView parentFrame) {
		initialize();
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
	
	public SelecionarEnderecoView(GerenteView parentFrame) {
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
	
	public SelecionarEnderecoView(DiretorView parentFrame) {
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
		setTitle("Endereços");
		setBounds(100, 100, 450, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnCadEnd = new JButton("Cadastrar Endereço");
        btnCadEnd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadastrarEnderecoView cadastrarEnderecoView = new CadastrarEnderecoView(SelecionarEnderecoView.this);
                cadastrarEnderecoView.setVisible(true);
                
                SelecionarEnderecoView.this.setVisible(false);
            }
        });
        btnCadEnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnCadEnd.setBounds(108, 48, 206, 69);
        getContentPane().add(btnCadEnd);
        
        JButton btnCadLoja = new JButton("Cadastrar Loja");
        btnCadLoja.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                CadastrarLojaView cadastrarLojaView = new CadastrarLojaView(SelecionarEnderecoView.this);
                cadastrarLojaView.setVisible(true);

                //SelecionarEnderecoView.this.setVisible(false);
        	}
        });
        btnCadLoja.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnCadLoja.setBounds(108, 144, 206, 69);
        getContentPane().add(btnCadLoja);
        
        JButton btnCadLocal = new JButton("Cadastrar Local");
        btnCadLocal.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                CadastrarLocalView cadastrarLocalView = new CadastrarLocalView(SelecionarEnderecoView.this);
                cadastrarLocalView.setVisible(true);

                //SelecionarEnderecoView.this.setVisible(false);
        	}
        });
        btnCadLocal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnCadLocal.setBounds(108, 241, 206, 69);
        getContentPane().add(btnCadLocal);
	}

}
