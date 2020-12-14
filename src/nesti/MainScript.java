package nesti;

import java.awt.EventQueue;


public class MainScript {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLogin viewLogin = new ViewLogin();
					// window.frame.setVisible(true);


				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
