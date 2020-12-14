package nesti;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import toolsDesign.*;

public class ViewLogin extends JFrame {

	protected JFrame frame;
	private JTextField txtIdLog;
	private JLabel IdLog;
	private JLabel lblPasswordLog;
	private JTextField txtPassword;
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

		
		TextField txtIdLog = new TextField(295);
		containerForm.add(txtIdLog);
		
		IdLog = new JLabel("Email ou pseudo");
		IdLog.setFont(new Font("Tahoma", Font.PLAIN, 17));
		IdLog.setBounds(311, 295, 177, 32);
		containerForm.add(IdLog);
		
		lblPasswordLog = new JLabel("Mot de passe");
		lblPasswordLog.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPasswordLog.setBounds(311, 395, 177, 32);
		containerForm.add(lblPasswordLog);
		
		TextField txtPassword = new TextField(395);
		containerForm.add(txtPassword);
		
		
		Buttons btnForgetPassword = new Buttons("Mot de passe oubli\u00E9",489, 660, 165, 42);
		containerForm.add(btnForgetPassword);
		
		
		Buttons btnSubmit = new Buttons("Valider",734, 519, 108, 35);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String passwordTap = txtPassword.getText();
				String email;
				ResultSet resultInfo = null;
				
				try {
					MyConnexion.openConnection();
					String query ="SELECT password, email, alias from `member` where email = ? or alias = ?";
					PreparedStatement declaration = MyConnexion.accessDataBase.prepareStatement(query);
					declaration.setString(1, txtIdLog.getText());
					declaration.setString(2, txtIdLog.getText());
						
					resultInfo = declaration.executeQuery();
												
					if (resultInfo.next()) {
	
						email = resultInfo.getString("email");
						boolean matched = HashPassword.validatePassword(passwordTap,resultInfo.getString(1));
					
						if(matched) {					
							System.out.println("bravo");
							
							frame.dispose();
							Member member = new Member(email,txtPassword.getText());
							
							ViewProfile profileMember = new ViewProfile(member);
							
						}
						else {
							System.out.println("erreur mdp");
							JOptionPane.showMessageDialog(frame,"Votre email ou mot de passe ne sont pas valides.");
						}
						
					}
					else {
						System.out.println("erreur email - login");
						JOptionPane.showMessageDialog(frame,"Votre email ou mot de passe ne sont pas valides.");
					}
	
				} catch (Exception e) {
					System.err.println("Erreur de r�cup�ration des informations du membre " + e.getMessage());
				}

				
				
				// methode deux avec getters & setters KO
		/*		DALQuery.selectLoginMember(txtIdLog.getText(),txtPassword.getText());
				
				if(DALQuery.getIsMemberEmailIsOk()) {
					System.out.println("bravo");
				}
				else {
					System.out.println("echec");

				}
				*/
			
			}
		});
		containerForm.add(btnSubmit);
		
	
		Buttons btnCancel = new Buttons("Annuler",576, 519, 108, 35);
		containerForm.add(btnCancel);
		
		JLabel lblConnexion = new JLabel("CONNEXION");
		lblConnexion.setHorizontalAlignment(SwingConstants.CENTER);
		lblConnexion.setFont(new Font("Verdana", Font.PLAIN, 22));
		lblConnexion.setBounds(471, 67, 262, 41);
		containerForm.add(lblConnexion);
		
		
		Buttons btnCreateAccount = new Buttons ("Cr\u00E9er un compte",941, 81, 177, 42);
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				ViewInscription frameInscription = new ViewInscription();
			//	frameInscription.setVisible(true);
				
			}
		});
		containerForm.add(btnCreateAccount);
	
		JPanel ContaineurLogo = new JPanel();
		ContaineurLogo.setBackground(SystemColor.window);
		ContaineurLogo.setBounds(10, 11, 208, 213);
		containerForm.add(ContaineurLogo);
		ContaineurLogo.setLayout(null);

		JLabel lblLogo = new JLabel("");
		lblLogo.setBackground(SystemColor.window);
		Image logo = new ImageIcon(this.getClass().getResource("/logoNesti.png")).getImage();
		lblLogo.setIcon(new ImageIcon(logo));
		lblLogo.setBounds(0, 0, 200, 195);
		ContaineurLogo.add(lblLogo);

		JPanel ContainerBackground = new JPanel();
		ContainerBackground.setBounds(0, 0, 1184, 1061);
		containerForm.add(ContainerBackground);
		ContainerBackground.setLayout(null);

		JLabel lblBackground = new JLabel("");
		lblBackground.setRequestFocusEnabled(false);
		lblBackground.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		Image background = new ImageIcon(this.getClass().getResource("/background.jpg")).getImage();
		lblBackground.setIcon(new ImageIcon(background));

		lblBackground.setBounds(0, 0, 1184, 1061);
		ContainerBackground.add(lblBackground);

	
	}
}
