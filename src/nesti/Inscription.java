package nesti;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class Inscription {

	private JFrame frame;
	private JTextField txtLastName;
	private JTextField txtFirstName;
	private JTextField txtAlias;
	private JTextField txtEmail;
	private JTextField txtTown;
	private JTextField txtPassword1;
	private JTextField txtPassword2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inscription window = new Inscription();
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
	public Inscription() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 765, 658);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel container = new JPanel();
		frame.getContentPane().add(container, BorderLayout.CENTER);
		container.setLayout(null);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(413, 124, 234, 32);
		container.add(txtLastName);
		txtLastName.setColumns(10);
		
		JLabel lblInscription = new JLabel("INSCRIPTION");
		lblInscription.setFont(new Font("Verdana", Font.PLAIN, 22));
		lblInscription.setHorizontalAlignment(SwingConstants.CENTER);
		lblInscription.setBounds(240, 22, 262, 41);
		container.add(lblInscription);
		
		JLabel lblName = new JLabel("Nom");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblName.setBounds(125, 129, 72, 23);
		container.add(lblName);
		
		JLabel lblFistName = new JLabel("Pr\u00E9nom");
		lblFistName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFistName.setBounds(125, 189, 72, 23);
		container.add(lblFistName);
		
		txtFirstName = new JTextField();
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(413, 184, 234, 32);
		container.add(txtFirstName);
		
		JLabel lblAlias = new JLabel("Pseudo*");
		lblAlias.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAlias.setBounds(125, 249, 72, 23);
		container.add(lblAlias);
		
		txtAlias = new JTextField();
		txtAlias.setColumns(10);
		txtAlias.setBounds(413, 244, 234, 32);
		container.add(txtAlias);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(413, 307, 234, 32);
		container.add(txtEmail);
		
		JLabel lblEmail = new JLabel("Email*");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEmail.setBounds(125, 312, 72, 23);
		container.add(lblEmail);
		
		JLabel lblTown = new JLabel("Ville");
		lblTown.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTown.setBounds(125, 377, 72, 23);
		container.add(lblTown);
		
		txtTown = new JTextField();
		txtTown.setColumns(10);
		txtTown.setBounds(413, 372, 234, 32);
		container.add(txtTown);
		
		
		JLabel lblPassword1 = new JLabel("Mot de passe*");
		lblPassword1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPassword1.setBounds(125, 433, 133, 23);
		container.add(lblPassword1);
		
		txtPassword1 = new JTextField();
		txtPassword1.setColumns(10);
		txtPassword1.setBounds(413, 428, 234, 32);
		container.add(txtPassword1);
		
		JLabel lblPassword2 = new JLabel("Confirmation mot de passe*");
		lblPassword2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPassword2.setBounds(125, 497, 226, 23);
		container.add(lblPassword2);
		
		txtPassword2 = new JTextField();
		txtPassword2.setColumns(10);
		txtPassword2.setBounds(413, 492, 234, 32);
		container.add(txtPassword2);
		
		JButton btnSubmit = new JButton("Valider");
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSubmit.setBounds(570, 573, 108, 35);
		container.add(btnSubmit);
		
		JButton btnCancel = new JButton("Annuler");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(430, 573, 108, 35);
		container.add(btnCancel);
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConnexion.setBounds(595, 22, 126, 41);
		container.add(btnConnexion);
	}
}

