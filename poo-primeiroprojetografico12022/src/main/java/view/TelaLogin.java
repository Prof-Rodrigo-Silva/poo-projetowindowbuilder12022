package view;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import control.dao.ClasseDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JSeparator;

public class TelaLogin {

	private JFrame frame;
	private JTextField txtLogin;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin window = new TelaLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setBounds(40, 74, 81, 33);
		frame.getContentPane().add(lblNewLabel);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(163, 74, 226, 33);
		frame.getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 20));
		lblPassword.setBounds(40, 119, 155, 34);
		frame.getContentPane().add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(163, 122, 226, 33);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtLogin.getText().isEmpty() && !txtPassword.getText().isEmpty()) {
					ClasseDAO dao = new ClasseDAO();
					try {
						if(dao.buscar(txtLogin.getText(), txtPassword.getText())) {
							TelaSystem TelaSystem = new TelaSystem();
							TelaSystem.main(null);
							//JOptionPane.showMessageDialog(null, "Acessou!");
							txtLogin.setText(null);
							txtPassword.setText(null);
						}else {
							JOptionPane.showMessageDialog(null, "Dados de login inválidos","Erro de Acesso",JOptionPane.ERROR_MESSAGE);
							txtLogin.setText(null);
							txtPassword.setText(null);
						}
					} catch (HeadlessException e1) {
						e1.printStackTrace();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Preencha os campos","Aviso",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnAcessar.setBounds(12, 216, 117, 25);
		frame.getContentPane().add(btnAcessar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtLogin.setText(null);
				txtPassword.setText(null);
			}
		});
		btnLimpar.setBounds(163, 216, 117, 25);
		frame.getContentPane().add(btnLimpar);
		
		JLabel lblAcessoAoSistema = new JLabel("Acesso ao Sistema");
		lblAcessoAoSistema.setFont(new Font("Dialog", Font.BOLD, 30));
		lblAcessoAoSistema.setBounds(67, 12, 322, 42);
		frame.getContentPane().add(lblAcessoAoSistema);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 60, 416, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 180, 416, 2);
		frame.getContentPane().add(separator_1);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Deseja sair do sistema?","Acesso ao Sistema",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
					
			}
		});
		btnSair.setBounds(311, 216, 117, 25);
		frame.getContentPane().add(btnSair);
	}
}
