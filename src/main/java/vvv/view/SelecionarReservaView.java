package main.java.vvv.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class SelecionarReservaView extends JFrame {

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
					SelecionarReservaView window = new SelecionarReservaView();
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
	public SelecionarReservaView() {
		initialize();
	}

	public SelecionarReservaView(FuncionarioView parentFrame) {
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

	public SelecionarReservaView(GerenteView parentFrame) {
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

	public SelecionarReservaView(DiretorView parentFrame) {
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
		
		setBounds(100, 100, 450, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnCadRes = new JButton("Cadastrar Reserva");
		btnCadRes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadRes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCadRes.setBounds(104, 59, 224, 107);
		getContentPane().add(btnCadRes);
		
		JButton btnCadTkt = new JButton("Cadastrar Ticket");
		btnCadTkt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadTkt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCadTkt.setBounds(104, 200, 224, 107);
		getContentPane().add(btnCadTkt);
	}
}
