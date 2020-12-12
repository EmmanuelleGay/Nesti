package nesti;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.Color;

public class DesignInscription extends JFrame{

	private JPanel contentPane;
	private JTextField txtLastName;
	private JTextField txtFirstName;
	private JTextField txtAlias;
	private JTextField txtEmail;
	private JTextField txtTown;
	private JPasswordField txtpassword1;
	private JPasswordField txtpassword2;


	/**
	 * Create the application.
	 */
	
	DesignInscription frameInscription;

	public DesignInscription() {

		initializeInscription();
	//	constructForm(containerForm);
		
	// initializeForm();
	
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initializeInscription() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 1100);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		

		JPanel containerForm = new JPanel();
		contentPane.add(containerForm, BorderLayout.CENTER);
		containerForm.setLayout(null);
		
		/*
		 * -------------------------------SPECIFIC FORM A METTRE DANS UNE CLASSE A
		 * PART-----------------------
		 */

		txtLastName = new JTextField();
		txtLastName.setBounds(577, 222, 234, 32);
		containerForm.add(txtLastName);
		txtLastName.setColumns(10);

		JLabel lblInscription = new JLabel("INSCRIPTION");
		lblInscription.setBounds(433, 96, 262, 41);
		lblInscription.setFont(new Font("Verdana", Font.PLAIN, 22));
		lblInscription.setHorizontalAlignment(SwingConstants.CENTER);
		containerForm.add(lblInscription);

		JLabel lblName = new JLabel("Nom");
		lblName.setBounds(289, 222, 72, 23);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		containerForm.add(lblName);

		JLabel lblFirstName = new JLabel("Pr\u00E9nom");
		lblFirstName.setBounds(289, 282, 72, 23);
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		containerForm.add(lblFirstName);

		txtFirstName = new JTextField();
		txtFirstName.setBounds(577, 282, 234, 32);
		txtFirstName.setColumns(10);
		containerForm.add(txtFirstName);

		JLabel lblAlias = new JLabel("Pseudo*");
		lblAlias.setBounds(289, 342, 72, 23);
		lblAlias.setFont(new Font("Tahoma", Font.PLAIN, 17));
		containerForm.add(lblAlias);

		txtAlias = new JTextField();
		txtAlias.setBounds(577, 342, 234, 32);
		txtAlias.setColumns(10);
		containerForm.add(txtAlias);

		txtEmail = new JTextField();
		txtEmail.setBounds(577, 405, 234, 32);
		txtEmail.setColumns(10);
		containerForm.add(txtEmail);

		JLabel lblEmail = new JLabel("Email*");
		lblEmail.setBounds(289, 405, 72, 23);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		containerForm.add(lblEmail);

		JLabel lblTown = new JLabel("Ville");
		lblTown.setBounds(289, 470, 72, 23);
		lblTown.setFont(new Font("Tahoma", Font.PLAIN, 17));
		containerForm.add(lblTown);

		txtTown = new JTextField();
		txtTown.setBounds(577, 470, 234, 32);
		txtTown.setColumns(10);
		containerForm.add(txtTown);

		JLabel lblPassword1 = new JLabel("Mot de passe*");
		lblPassword1.setBounds(289, 526, 133, 23);
		lblPassword1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		containerForm.add(lblPassword1);

		JLabel lblPassword2 = new JLabel("Confirmation mot de passe*");
		lblPassword2.setBounds(295, 633, 226, 23);
		lblPassword2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		containerForm.add(lblPassword2);

		JButton btnSubmit = new JButton("Valider");
		btnSubmit.setBounds(703, 729, 108, 35);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// check if user insert same password
				if (String.valueOf(txtpassword1.getPassword()).equals(String.valueOf(txtpassword2.getPassword()))) {

					// check if email is valid
					EmailValidator emailValidator = new EmailValidator();
					if (emailValidator.validate(txtEmail.getText().trim())) {

						// check if password is valid
						PasswordValidator passwordValidator = new PasswordValidator();
						if (passwordValidator.validate(String.valueOf(txtpassword1.getPassword()))) {

							// everything is ok, create object member
							Member member = new Member(txtLastName.getText(), txtFirstName.getText(),
									txtAlias.getText(), txtEmail.getText(), txtTown.getText(),
									String.valueOf(txtpassword1.getPassword()));

							// hash and salt password
							try {
								HashPassword.generateHashPassword(member);
							} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							// insert member in db
							DALQuery.createMember(member);
							
							//acces to profil page
							frameInscription.dispose();
							ViewProfile frameprofile = new ViewProfile(member);
							frameprofile.setVisible(true);
							
						} else {
							JOptionPane.showMessageDialog(frameInscription, "Le mot de passe n'est pas valide");
						}

					} else {
						JOptionPane.showMessageDialog(frameInscription, "Le format d'email est incorrect");
					}

				} else {
					JOptionPane.showMessageDialog(frameInscription, "Les mots de passe ne correspondent pas");
				}

			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		containerForm.add(btnSubmit);

		JButton btnCancel = new JButton("Annuler");
		btnCancel.setBounds(535, 729, 108, 35);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		containerForm.add(btnCancel);

		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frameInscription.dispose();
				DesignLogin login = new DesignLogin();
				login.setVisible(true);
			}
		});
		btnConnexion.setBounds(964, 99, 126, 41);
		btnConnexion.setFont(new Font("Tahoma", Font.PLAIN, 15));
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
				"Le mot de passe doit contenir au moins 8 caract\u00E8res, dont un chiffre, une majsucule, une minuscule et un caract\u00E8re sp\u00E9cial.");
		containerForm.add(txtrLeMotDe);
	
		
		
		
		
		
		/******************************************A METTRE DANS MODELE**************************************/

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
	
//	private void constructForm(JPanel containerForm) {

}
