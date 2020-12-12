package nesti;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewProfile extends JFrame {

	private JPanel contentPane;
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
		// txtPassword1.setText(member.getPassword());
		// txtPassword2.setText(member.getPassword());

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 1100);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel containerForm = new JPanel();
		contentPane.add(containerForm, BorderLayout.CENTER);
		containerForm.setLayout(null);

		JLabel lblName = new JLabel("Nom");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblName.setBounds(318, 228, 72, 23);
		containerForm.add(lblName);

		JLabel lblFirstName = new JLabel("Pr\u00E9nom");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFirstName.setBounds(318, 288, 72, 23);
		containerForm.add(lblFirstName);

		JLabel lblAlias = new JLabel("Pseudo*");
		lblAlias.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAlias.setBounds(318, 348, 72, 23);
		containerForm.add(lblAlias);

		JLabel lblEmail = new JLabel("Email*");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEmail.setBounds(318, 411, 72, 23);
		containerForm.add(lblEmail);

		JLabel lblTown = new JLabel("Ville");
		lblTown.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTown.setBounds(318, 476, 72, 23);
		containerForm.add(lblTown);

		JLabel lblPassword1 = new JLabel("Mot de passe*");
		lblPassword1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPassword1.setBounds(318, 541, 133, 23);
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

		JLabel lblPassword2 = new JLabel("Confirmation mot de passe*");
		lblPassword2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPassword2.setBounds(324, 637, 226, 23);
		containerForm.add(lblPassword2);

		txtPassword2 = new JPasswordField();
		txtPassword2.setBounds(606, 635, 234, 32);
		containerForm.add(txtPassword2);

		JLabel lblAgreeUpdate = new JLabel("Je souhaite modifier mes informations");
		lblAgreeUpdate.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAgreeUpdate.setBounds(324, 714, 414, 23);
		containerForm.add(lblAgreeUpdate);

		JCheckBox chckbxAgreeUpdate = new JCheckBox("");
		chckbxAgreeUpdate.setBounds(814, 717, 97, 23);
		containerForm.add(chckbxAgreeUpdate);

		JButton btnCancel = new JButton("Annuler");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(564, 778, 108, 35);
		containerForm.add(btnCancel);

		JButton btnSubmit = new JButton("Valider");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxAgreeUpdate.isSelected()) {
					DALQuery.selectIdMember(member);
					updateUser();
					DALQuery.updateMember(member);
					JOptionPane.showMessageDialog(null,"Vos modifications ont bien été prises en compte");
				}
				else {
					JOptionPane.showMessageDialog(null,"Vous devez accepter de modifier vos informations");
				}
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSubmit.setBounds(732, 778, 108, 35);
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

		JButton btnDconnexion = new JButton("D\u00E9connexion");
		btnDconnexion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDconnexion.setBounds(975, 84, 126, 41);
		containerForm.add(btnDconnexion);

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
