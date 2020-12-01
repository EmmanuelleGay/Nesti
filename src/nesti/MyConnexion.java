package nesti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MyConnexion {

	static Connection accessDataBase = null;

	/**
	 * Testons la connexion
	 */

	public static void main(String[] args) {
		openConnection();
		testConnection();
		closeConnection();
	}

	/**
	 * Connexion � ma base de donn�e NESTI
	 * 
	 * @throws SQLException
	 */
	public static void openConnection() {
		/* Parametres de connexion */
		String url = "jdbc:mysql://127.0.0.1/nesti ?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
		// nesti = nom de ma bdd le reste est pour le pb de fuseau horaire
		String utilisateur = "root";
		String motDePasse = "";
		try {
			System.out.println("try to connect");
			// on ajoute nos param�tres
			accessDataBase = DriverManager.getConnection(url, utilisateur, motDePasse);
		} catch (SQLException ex) {
			Logger.getLogger(MyConnexion.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static boolean testConnection() {
		boolean flag = false;
		try {
			if (accessDataBase != null) {
				if (!accessDataBase.isClosed()) {
					System.out.println("Connexion au serveur... OK");
					flag = true;
				}
			}
		} catch (SQLException ex) {
			Logger.getLogger(MyConnexion.class.getName()).log(Level.SEVERE, null, ex);
		}
		return flag;

	};
	
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
