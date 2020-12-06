package nesti;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class DesignLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdLog;
	private JLabel IdLog;
	private JLabel lblPasswordLog;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DesignLogin frame = new DesignLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DesignLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 1100);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel containerForm = new JPanel();
		contentPane.add(containerForm, BorderLayout.CENTER);
		containerForm.setLayout(null);
		
		txtIdLog = new JTextField();
		txtIdLog.setColumns(10);
		txtIdLog.setBounds(608, 295, 234, 32);
		containerForm.add(txtIdLog);
		
		IdLog = new JLabel("Email ou pseudo");
		IdLog.setFont(new Font("Tahoma", Font.PLAIN, 17));
		IdLog.setBounds(311, 295, 177, 32);
		containerForm.add(IdLog);
		
		lblPasswordLog = new JLabel("Mot de passe");
		lblPasswordLog.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPasswordLog.setBounds(311, 395, 177, 32);
		containerForm.add(lblPasswordLog);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(608, 395, 234, 32);
		containerForm.add(txtPassword);
		
		JButton btnNewButton = new JButton("Mot de passe oubli\u00E9");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(489, 660, 159, 40);
		containerForm.add(btnNewButton);
		
		JButton btnSubmit = new JButton("Valider");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					MyConnexion.openConnection();
					String query ="SELECT * from `member` where email = ? and password = ?";
					PreparedStatement declaration = MyConnexion.accessDataBase.prepareStatement(query);
					declaration.setString(1, txtIdLog.getText());
					declaration.setString(2, txtPassword.getText());
					
					ResultSet resultInfo = declaration.executeQuery();
	
					System.out.println(resultInfo);
				
					if (resultInfo.next()) {
						System.out.println("bravo");
					}
					else {
						System.out.println("echec");
					}
				
				} catch (Exception e) {
					System.err.println("Erreur de récupération des informations du membre " + e.getMessage());
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
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSubmit.setBounds(734, 519, 108, 35);
		containerForm.add(btnSubmit);
		
		JButton btnCancel = new JButton("Annuler");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(576, 519, 108, 35);
		containerForm.add(btnCancel);
		
		JLabel lblConnexion = new JLabel("CONNEXION");
		lblConnexion.setHorizontalAlignment(SwingConstants.CENTER);
		lblConnexion.setFont(new Font("Verdana", Font.PLAIN, 22));
		lblConnexion.setBounds(471, 67, 262, 41);
		containerForm.add(lblConnexion);
		
		JButton btnCrerUnCompte = new JButton("Cr\u00E9er un compte");
		btnCrerUnCompte.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCrerUnCompte.setBounds(941, 81, 177, 41);
		containerForm.add(btnCrerUnCompte);
	
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
