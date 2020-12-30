package nesti;



import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.Color;

import toolsDesign.*;

public class ViewInscription extends JFrame {

	private JFrame frame;
	private TextField txtLastName;
	private TextField txtFirstName;
	private TextField txtAlias;
	private TextField txtEmail;
	private TextField txtTown;
	private JPasswordField txtpassword1;
	private JPasswordField txtpassword2;
	/**
	 * Create the application.
	 */

	public ViewInscription() {
		initializeInscription();

	}

	
	/**
	 * Clear text field
	 */
	private void resetTextField() {
		txtLastName.setText("");
		txtFirstName.setText("");
		txtAlias.setText("");
		txtEmail.setText("");
		txtTown.setText("");
		txtpassword1.setText("");
		txtpassword2.setText("");
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */

	private void initializeInscription() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1200, 1100);

		JPanel containerForm = new JPanel();
		frame.getContentPane().add(containerForm, BorderLayout.CENTER);
		containerForm.setLayout(null);
		
		TextField txtLastName = new TextField("txtLastName",222);
		containerForm.add(txtLastName);

		Label lblInscription = new Label("INSCRIPTION");
		containerForm.add(lblInscription);

		Label lblName = new Label("Nom",222);
		containerForm.add(lblName);

		Label lblFirstName = new Label("Pr\u00E9nom",282);
		containerForm.add(lblFirstName);

		TextField txtFirstName = new TextField("txtFirstName",282);
		containerForm.add(txtFirstName);

		Label lblAlias = new Label("Pseudo*",342);
		containerForm.add(lblAlias);

		TextField txtAlias = new TextField("txtAlias",342);
		containerForm.add(txtAlias);

		TextField txtEmail = new TextField("txtEmail",405);
		containerForm.add(txtEmail);

		Label lblEmail = new Label("Email*",405);
		containerForm.add(lblEmail);

		Label lblTown = new Label("Ville",470);
		containerForm.add(lblTown);

		TextField txtTown = new TextField("txtTown",470);
		containerForm.add(txtTown);

		Label lblPassword1 = new Label("Mot de passe*",526);
		containerForm.add(lblPassword1);

		Label lblPassword2 = new Label("Confirmation mot de passe*",633);
		containerForm.add(lblPassword2);

	
		Buttons btnSubmit = new Buttons("Valider",703, 729, 108, 35);
	
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// check if email or alias already exist in db
				try {
					if (DalQuery.isEmailAlreadyExist(txtEmail.getText()) == false) {
						if (DalQuery.isAliasAlreadyExist(txtAlias.getText()) == false) {

							if (!txtAlias.getText().equals("")) {
								// check if user insert same password in both textfield
								if (String.valueOf(txtpassword1.getPassword())
										.equals(String.valueOf(txtpassword2.getPassword()))) {

									// check if email is a valid email
									EmailValidator emailValidator = new EmailValidator();
									if (emailValidator.validate(txtEmail.getText().trim())) {

										// check if password is a strong password
										PasswordValidator passwordValidator = new PasswordValidator();
										if (passwordValidator.validate(String.valueOf(txtpassword1.getPassword()))) {

											// everything is ok, create object member
											Member member = new Member(txtLastName.getText(), txtFirstName.getText(),
													txtAlias.getText(), txtEmail.getText(), txtTown.getText(),
													String.valueOf(txtpassword1.getPassword()));
											HashPassword hashPassword = new HashPassword();

											// hash and salt password
											try {
												hashPassword.generateHashPassword(String.valueOf(txtpassword1.getPassword()));
											} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}

											// insert member in db
											DalQuery.createMember(member, hashPassword);

											// acces to profil page
											frame.dispose();
											ViewProfile frameprofile = new ViewProfile(member);

										} else {
											JOptionPane.showMessageDialog(frame, "Le mot de passe n'est pas valide");
										}

									} else {
										JOptionPane.showMessageDialog(frame, "Le format d'email est incorrect");
									}

								} else {
									JOptionPane.showMessageDialog(frame, "Les mots de passe ne correspondent pas");
								}
							} else {
								JOptionPane.showMessageDialog(frame,
										"Vous devez compléter tous les champs obligatoires");
							}

						} else {
							JOptionPane.showMessageDialog(frame, "Ce pseudo existe déjà, merci d'en choisir un autre.");
						}
					}

					else {
						JOptionPane.showMessageDialog(frame, "Vous avez déjà un compté créé avec cette adresse email.");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		containerForm.add(btnSubmit);
	
		Buttons btnCancel = new Buttons("Annuler",576, 729, 108, 35);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetTextField();
			}
		});
		containerForm.add(btnCancel);

		Buttons btnConnexion = new Buttons("Connexion",998, 96, 108, 42);
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				ViewLogin viewLogin = new ViewLogin();

			}
		});
		
		containerForm.add(btnConnexion);

		txtpassword1 = new JPasswordField();
		txtpassword1.setBounds(577, 526, 234, 32);
		containerForm.add(txtpassword1);

		txtpassword2 = new JPasswordField();
		txtpassword2.setBounds(577, 631, 234, 32);
		containerForm.add(txtpassword2);

		JTextArea txtrLeMotDe = new JTextArea();
		txtrLeMotDe.setDisabledTextColor(new Color(95, 158, 160));
		txtrLeMotDe.setSelectionColor(new Color(0, 0, 0));
		txtrLeMotDe.setSelectedTextColor(new Color(95, 158, 160));
		txtrLeMotDe.setRequestFocusEnabled(false);
		txtrLeMotDe.setOpaque(false);
		txtrLeMotDe.setLineWrap(true);
		txtrLeMotDe.setWrapStyleWord(true);
		txtrLeMotDe.setBounds(285, 568, 526, 49);
		txtrLeMotDe.setForeground(Color.BLACK);
		txtrLeMotDe.setFont(new Font("Nirmala UI", Font.ITALIC, 14));
		txtrLeMotDe.setEnabled(false);
		txtrLeMotDe.setEditable(false);
		txtrLeMotDe.setText(
				"Le mot de passe doit contenir au moins 8 caract\u00E8res, dont un chiffre, une majuscule, une minuscule et un caract\u00E8re sp\u00E9cial.");
		containerForm.add(txtrLeMotDe);

		JPanel ContaineurLogo = new JPanel();
		ContaineurLogo.setBackground(SystemColor.window);
		ContaineurLogo.setBounds(10, 11, 208, 213);
		containerForm.add(ContaineurLogo);
		ContaineurLogo.setLayout(null);

		Label lblLogo = new Label("logo",0);
		ContaineurLogo.add(lblLogo);

		JPanel ContainerBackground = new JPanel();
		ContainerBackground.setBounds(0, 0, 1184, 1061);
		containerForm.add(ContainerBackground);
		ContainerBackground.setLayout(null);

		Label lblBackground = new Label("background",0);
		ContainerBackground.add(lblBackground);

	}
	


}
