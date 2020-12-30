package nesti;

import java.awt.BorderLayout;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;

import toolsDesign.Buttons;
import toolsDesign.Label;
import toolsDesign.TextField;

public class ViewPasswordForget {
	private JFrame frame;

	public ViewPasswordForget() {
		initializeViewPasswordForget();
	}
	
	private void initializeViewPasswordForget() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1200, 1100);

		JPanel containerForm = new JPanel();
		frame.getContentPane().add(containerForm, BorderLayout.CENTER);
		containerForm.setLayout(null);
		
		Label lblMonProfil = new Label("MOT DE PASSE OUBLIÉ");
		containerForm.add(lblMonProfil);
		
		Label lbltextPassword = new Label ("Email", 300);
		containerForm.add(lbltextPassword);
		
		TextField txtEmail = new TextField("txtEmail",300);
		containerForm.add(txtEmail);

		Buttons btnSubmit = new Buttons("Valider",703, 450, 108, 35);
		containerForm.add(btnSubmit);
		
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
