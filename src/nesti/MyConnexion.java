package nesti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MyConnexion {

	static Connection accessDataBase = null;

	/**
	 * open connexion to database Nesti
	 * 
	 * @throws SQLException
	 */
	public static void openConnection() {
		String url = "jdbc:mysql://127.0.0.1/nesti ?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
		String utilisateur = "root";
		String motDePasse = "";
		try {
			System.out.println("try to connect");
			accessDataBase = DriverManager.getConnection(url, utilisateur, motDePasse);
		} catch (SQLException ex) {
			Logger.getLogger(MyConnexion.class.getName()).log(Level.SEVERE, null, ex);
		}
	}


	/**
	 * close connection and alert if needed
	 */
	public static void closeConnection() {
		if (accessDataBase != null) {
			try {
				accessDataBase.close();
				System.out.println("Close connection");
			} catch (SQLException e) {
				System.err.println("Erreur fermreture: " + e.getMessage());
			}
		}

	};

}
