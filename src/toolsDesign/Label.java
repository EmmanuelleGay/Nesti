package toolsDesign;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Label extends JLabel {

	/**
	 * Constructor for logo, background and classic Label
	 * 
	 * @param name
	 * @param y
	 */
	public Label(String name, int y) {
		if (name.equals("logo")) {
			this.setBackground(SystemColor.window);
			Image logo = new ImageIcon(this.getClass().getResource("/logoNesti.png")).getImage();
			this.setIcon(new ImageIcon(logo));
			this.setBounds(0, y, 200, 195);
		}

		else if (name.equals("background")) {
			this.setRequestFocusEnabled(false);
			Image background = new ImageIcon(this.getClass().getResource("/background.jpg")).getImage();
			this.setIcon(new ImageIcon(background));
			this.setBounds(0, 0, 1184, 1061);
		}

		else {
			this.setBounds(289, y, 550, 23);
			this.setFont(new Font("Tahoma", Font.PLAIN, 17));
			this.setForeground(new Color(0, 0, 0));
			this.setText(name);
		}
	}

	/**
	 * Constructor for header
	 * 
	 * @param name
	 */
	public Label(String name) {
		this.setBounds(350, 96, 500, 41);
		this.setFont(new Font("Verdana", Font.PLAIN, 35));
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setText(name);
	}

}
