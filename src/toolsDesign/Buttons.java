package toolsDesign;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class Buttons extends JButton{

/**
 * used to create a new buttons in the application
 * @param name
 * @param x
 * @param y
 * @param L
 * @param l
 */
	
	public Buttons(String name, int x, int y, int L, int l) {
		this.setText(name);
		this.setBounds(x,y,L,l);
		
		// small butttons
		if (l < 40) {
			this.setFont(new Font("Tahoma", Font.BOLD, 17));
			this.setForeground(new Color(255,255,255));
			this.setBackground(new Color(147,207,228));
		}
		
		// big buttons
		else {
			this.setFont(new Font("Tahoma", Font.PLAIN, 15));
			this.setForeground(new Color(99,202,198));
			this.setBackground(new Color(255,255,255));
		}
		
		
		

	}

}
