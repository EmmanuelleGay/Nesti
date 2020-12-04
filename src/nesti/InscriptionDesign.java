package nesti;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class InscriptionDesign {

	private JFrame frame;
	private JTextField txtLastName;
	private JTextField txtFirstName;
	private JTextField txtAlias;
	private JTextField txtEmail;
	private JTextField txtTown;
	private JPasswordField txtpassword1;
	private JPasswordField txtpassword2;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InscriptionDesign window = new InscriptionDesign();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * public Object[] insertRow() { Member member = new Member(); Object[] row =
	 * member.toRow(); return row; }
	 */

	/**
	 * Create the application.
	 */

	public InscriptionDesign() {
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

		JLabel lblFirstName = new JLabel("Pr\u00E9nom");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFirstName.setBounds(125, 189, 72, 23);
		container.add(lblFirstName);

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

		JLabel lblPassword2 = new JLabel("Confirmation mot de passe*");
		lblPassword2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPassword2.setBounds(125, 497, 226, 23);
		container.add(lblPassword2);

		JButton btnSubmit = new JButton("Valider");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// check if user insert same password
				if (String.valueOf(txtpassword1.getPassword()).equals(String.valueOf(txtpassword2.getPassword()))) {

					// check if email is validate
					EmailValidator emailValidator = new EmailValidator();
					if (emailValidator.validate(txtEmail.getText().trim())) {

						// check if password is validate
						PasswordValidator passwordValidator = new PasswordValidator();
						if (passwordValidator.validate(String.valueOf(txtpassword1.getPassword()))) {
								
							//everything is ok, create member with textfield
							Member member = new Member(txtLastName.getText(), txtFirstName.getText(),
									txtAlias.getText(), txtEmail.getText(), txtTown.getText(),
									String.valueOf(txtpassword1.getPassword()));
							

						//	HashPassword hashPassword = new HashPassword();
							try {
								HashPassword.generateHashPassword(member);
							} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							
							//insert member in db
							QueryInscription.createMember(member);
						}
						else {
							JOptionPane.showMessageDialog(frame, "Le mot de passe n'est pas valide");
						}

					} else {
						JOptionPane.showMessageDialog(frame, "Le format d'email est incorrect");
					}

				} else {
					JOptionPane.showMessageDialog(frame, "Les mots de passe ne correspondent pas");
				}

			}
		});
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

		txtpassword1 = new JPasswordField();
		txtpassword1.setBounds(413, 437, 234, 32);
		container.add(txtpassword1);

		txtpassword2 = new JPasswordField();
		txtpassword2.setBounds(413, 501, 234, 32);
		container.add(txtpassword2);
	}
}
