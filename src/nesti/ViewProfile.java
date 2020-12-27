package nesti;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import toolsDesign.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.awt.event.ActionEvent;

public class ViewProfile extends JFrame {

	private JFrame frame;
	private JTextField txtLastName;
	private JTextField txtFirstName;
	private JTextField txtAlias;
	private JTextField txtEmail;
	private JTextField txtTown;
	private JPasswordField txtPassword1;
	private JPasswordField txtPassword2;

	/**
	 * Launch the application.
	 */

	Member member;

	public ViewProfile(Member member) {
		DalQuery.selectIdMember(member);
		setMember(member);
		initializeViewProfile();
		displayMemberInformation();
	}

	private void displayMemberInformation() {
		txtLastName.setText(member.getLastName());
		txtFirstName.setText(member.getFirstName());
		txtAlias.setText(member.getAlias());
		txtEmail.setText(member.getEmail());
		txtTown.setText(member.getTown());
		txtPassword1.setText(member.getPassword());
		txtPassword2.setText(member.getPassword());
	}

	private void updateUser() {
		member.setLastName(txtLastName.getText());
		member.setFirstName(txtFirstName.getText());
		member.setAlias(txtAlias.getText());
		member.setEmail(txtEmail.getText());
		member.setTown(txtTown.getText());
	}

	/**
	 * Create the frame.
	 * 
	 * 
	 */

	private void initializeViewProfile() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1200, 1100);

		JPanel containerForm = new JPanel();
		frame.getContentPane().add(containerForm, BorderLayout.CENTER);
		containerForm.setLayout(null);

		Label lblName = new Label("Nom",228);
		containerForm.add(lblName);

		Label lblFirstName = new Label("Pr\u00E9nom",288);
//		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		lblFirstName.setBounds(318, 288, 72, 23);
		containerForm.add(lblFirstName);

		Label lblAlias = new Label("Pseudo*",348);
	//	lblAlias.setFont(new Font("Tahoma", Font.PLAIN, 17));
	//	lblAlias.setBounds(318, 348, 72, 23);
		containerForm.add(lblAlias);

		Label lblEmail = new Label("Email*",411);
	//	lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
	//	lblEmail.setBounds(318, 411, 72, 23);
		containerForm.add(lblEmail);

		Label lblTown = new Label("Ville",476);
	//	lblTown.setFont(new Font("Tahoma", Font.PLAIN, 17));
	//	lblTown.setBounds(318, 476, 72, 23);
		containerForm.add(lblTown);

		Label lblPassword1 = new Label("Mot de passe*",541);
	//	lblPassword1.setFont(new Font("Tahoma", Font.PLAIN, 17));
	//	lblPassword1.setBounds(318, 541, 133, 23);
		containerForm.add(lblPassword1);

		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		txtLastName.setBounds(606, 228, 234, 32);
		containerForm.add(txtLastName);

		txtFirstName = new JTextField();
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(606, 288, 234, 32);
		containerForm.add(txtFirstName);

		txtAlias = new JTextField();
		txtAlias.setColumns(10);
		txtAlias.setBounds(606, 348, 234, 32);
		containerForm.add(txtAlias);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(606, 411, 234, 32);
		containerForm.add(txtEmail);

		txtTown = new JTextField();
		txtTown.setColumns(10);
		txtTown.setBounds(606, 476, 234, 32);
		containerForm.add(txtTown);

		txtPassword1 = new JPasswordField();
		txtPassword1.setBounds(606, 532, 234, 32);
		containerForm.add(txtPassword1);

		Label lblPassword2 = new Label("Confirmation mot de passe*",637);
	//	lblPassword2.setFont(new Font("Tahoma", Font.PLAIN, 17));
	//	lblPassword2.setBounds(324, 637, 226, 23);
		containerForm.add(lblPassword2);

		txtPassword2 = new JPasswordField();
		txtPassword2.setBounds(606, 635, 234, 32);
		containerForm.add(txtPassword2);

		Label lblAgreeUpdate = new Label("Je souhaite modifier mes informations",714);
	//	lblAgreeUpdate.setFont(new Font("Tahoma", Font.PLAIN, 17));
	//	lblAgreeUpdate.setBounds(324, 714, 414, 23);
		containerForm.add(lblAgreeUpdate);

		JCheckBox chckbxAgreeUpdate = new JCheckBox("");
		chckbxAgreeUpdate.setBounds(814, 717, 97, 23);
		containerForm.add(chckbxAgreeUpdate);

		Buttons btnCancel = new Buttons("Annuler",576, 789, 108, 35);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayMemberInformation();
			}
		});
		containerForm.add(btnCancel);

		Buttons btnSubmit = new Buttons("Valider",703, 789, 108, 35);
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxAgreeUpdate.isSelected()) {
					if (String.valueOf(txtPassword1.getPassword()).equals(String.valueOf(txtPassword2.getPassword()))) {
						// check if email is valid
						EmailValidator emailValidator = new EmailValidator();
						if (emailValidator.validate(txtEmail.getText().trim())) {

							// check if password is valid
							PasswordValidator passwordValidator = new PasswordValidator();
							if (passwordValidator.validate(String.valueOf(txtPassword1.getPassword()))) {

								HashPassword hashPassword = new HashPassword();
								// hash and salt password
								try {
									hashPassword.generateHashPassword(String.valueOf(txtPassword1.getPassword()));
								} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								// update info into screen
								updateUser();
								
								// update info into database
								DalQuery.updateMember(member, hashPassword);

								

								JOptionPane.showMessageDialog(frame, "Vos modifications ont bien été prises en compte");

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
					JOptionPane.showMessageDialog(frame, "Vous devez accepter de modifier vos informations");
				}
			}
		});
		containerForm.add(btnSubmit);

		JTextArea txtrLeMotDe = new JTextArea();
		txtrLeMotDe.setWrapStyleWord(true);
		txtrLeMotDe.setText(
				"Le mot de passe doit contenir au moins 8 caract\u00E8res, dont un chiffre, une majuscule, une minuscule et un caract\u00E8re sp\u00E9cial.");
		txtrLeMotDe.setSelectionColor(Color.BLACK);
		txtrLeMotDe.setSelectedTextColor(new Color(95, 158, 160));
		txtrLeMotDe.setRequestFocusEnabled(false);
		txtrLeMotDe.setOpaque(false);
		txtrLeMotDe.setLineWrap(true);
		txtrLeMotDe.setForeground(Color.BLACK);
		txtrLeMotDe.setFont(new Font("Nirmala UI", Font.ITALIC, 14));
		txtrLeMotDe.setEnabled(false);
		txtrLeMotDe.setEditable(false);
		txtrLeMotDe.setDisabledTextColor(new Color(95, 158, 160));
		txtrLeMotDe.setBounds(318, 575, 526, 49);
		containerForm.add(txtrLeMotDe);

		JLabel lblMonProfil = new JLabel("MON PROFIL");
		lblMonProfil.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonProfil.setFont(new Font("Verdana", Font.PLAIN, 22));
		lblMonProfil.setBounds(456, 70, 262, 41);
		containerForm.add(lblMonProfil);

		Buttons btnDeconnexion = new Buttons("D\u00E9connexion",941, 81, 177, 42);
		btnDeconnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				ViewLogin viewLogin = new ViewLogin();
				
			}
		});
		containerForm.add(btnDeconnexion);
		
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

	/**
	 * @return the member
	 */
	public Member getMember() {
		return member;
	}

	/**
	 * @param member the member to set
	 */
	public void setMember(Member member) {
		this.member = member;
	}

}
