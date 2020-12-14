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
/*
	public static void main(String[] args) {
		openConnection();
		testConnection();
		closeConnection();
	}
*/
	/**
	 * open connexion to database Nesti
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
			// on ajoute nos paramètres
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
