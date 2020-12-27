package toolsDesign;

import javax.swing.JTextField;

public class TextField extends JTextField {
private String txtNameField;
	


	public TextField(String name,int y) {
		this.txtNameField=name;
		this.setBounds(577, y, 234, 32);
		this.setColumns(10);
	}
	
	/**
 * @return the txtNameField
 */
public String getTxtNameField() {
	return txtNameField;
}

/**
 * @param txtNameField the txtNameField to set
 */
public void setTxtNameField(String txtNameField) {
	this.txtNameField = txtNameField;
}
}
