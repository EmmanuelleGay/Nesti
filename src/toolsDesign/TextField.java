package toolsDesign;

import javax.swing.JTextField;

public class TextField extends JTextField {


	public TextField(String name,int y) {
		this.setBounds(577, y, 234, 32);
		this.setColumns(10);
	}
	
}
