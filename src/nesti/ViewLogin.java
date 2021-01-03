package nesti;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.SystemColor;

import toolsControl.HashPassword;

import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import toolsDesign.*;

public class ViewLogin extends JFrame {

	protected JFrame frame;
	private JLabel IdLog;
	private JLabel lblPasswordLog;
	private JPasswordField txtPassword;
	Member member;
	

	public ViewLogin() {
		initializeLogin();
	}

	/**
	 * Create the frame.
	 */
	private void initializeLogin() {

		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 1200, 1100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel containerForm = new JPanel();
		frame.getContentPane().add(containerForm, BorderLayout.CENTER);
		containerForm.setLayout(null);

		TextField txtIdLog = new TextField("txtIdLog", 295);
		containerForm.add(txtIdLog);

		IdLog = new JLabel("Email ou pseudo");
		IdLog.setFont(new Font("Tahoma", Font.PLAIN, 17));
		IdLog.setBounds(311, 295, 177, 32);
		containerForm.add(IdLog);

		lblPasswordLog = new JLabel("Mot de passe");
		lblPasswordLog.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPasswordLog.setBounds(311, 395, 177, 32);
		containerForm.add(lblPasswordLog);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(577, 395, 234, 32);
		containerForm.add(txtPassword);

		Buttons btnForgetPassword = new Buttons("Mot de passe oubli\u00E9", 489, 660, 165, 42);
		btnForgetPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				ViewPasswordForget framePassword = new ViewPasswordForget();

			}
		});
		containerForm.add(btnForgetPassword);

		Buttons btnSubmit = new Buttons("Valider", 734, 519, 108, 35);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String email;
				ResultSet resultInfo = null;

				// Check if user exist in db
				try {
					MyConnexion.openConnection();
					String query = "SELECT password, email, alias from `member` where email = ? or alias = ?";
					PreparedStatement declaration = MyConnexion.accessDataBase.prepareStatement(query);
					declaration.setString(1, txtIdLog.getText());
					declaration.setString(2, txtIdLog.getText());

					resultInfo = declaration.executeQuery();

					if (resultInfo.next()) {

						email = resultInfo.getString("email");
						boolean matched = HashPassword.validatePassword(String.valueOf(txtPassword.getPassword()), resultInfo.getString(1));

						if (matched) {

							frame.dispose();
							Member member = new Member(email,String.valueOf(txtPassword.getPassword()));

							ViewProfile profileMember = new ViewProfile(member);

						} else {
							JOptionPane.showMessageDialog(frame, "Votre email ou mot de passe ne sont pas valides.");
						}

					} else {
						JOptionPane.showMessageDialog(frame, "Votre email ou mot de passe ne sont pas valides.");
					}

				} catch (Exception e) {
					System.err.println("Erreur de récupération des informations du membre " + e.getMessage());
				}

			}
		});
		containerForm.add(btnSubmit);

		Buttons btnCancel = new Buttons("Annuler", 576, 519, 108, 35);
		containerForm.add(btnCancel);

		Label lblConnexion = new Label("CONNEXION");
		containerForm.add(lblConnexion);

		Buttons btnCreateAccount = new Buttons("Cr\u00E9er un compte", 941, 81, 177, 42);
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				ViewInscription frameInscription = new ViewInscription();

			}
		});
		containerForm.add(btnCreateAccount);

		JPanel ContaineurLogo = new JPanel();
		ContaineurLogo.setBackground(SystemColor.window);
		ContaineurLogo.setBounds(10, 11, 208, 213);
		containerForm.add(ContaineurLogo);
		ContaineurLogo.setLayout(null);

		Label lblLogo = new Label("logo", 0);
		ContaineurLogo.add(lblLogo);

		JPanel ContainerBackground = new JPanel();
		ContainerBackground.setBounds(0, 0, 1184, 1061);
		containerForm.add(ContainerBackground);
		ContainerBackground.setLayout(null);

		Label lblBackground = new Label("background", 0);
		ContainerBackground.add(lblBackground);

		lblBackground.setBounds(0, 0, 1184, 1061);
		ContainerBackground.add(lblBackground);

	}
}
