package nesti;

import java.sql.Statement;
import java.util.Arrays;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryInscription extends MyConnexion {

	
	static boolean flag;
	static String name;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		openConnection();
		readAll();
	}

	
	public static void readAll() {
		try {
			Statement declaration = accessDataBase.createStatement();
			String query = "SELECT id, name FROM ingredients;";
			ResultSet resultat = declaration.executeQuery(query);

			/* Récupération des données */
			while (resultat.next()) {
				Member member = new Member();
				member.setId_member(resultat.getInt("id"));
				member.setLast_name(resultat.getString("name"));
				System.out.println(member.toString());
			}

		} catch (Exception e) {
			System.err.println("Erreur d'affichage membre: " + e.getMessage());
		}

	}
	
	
	/**
	 * insert member into database
	 * @param ingredient
	 * @return
	 */
	public static boolean createMember(String name) {
		try {
			String query = "INSERT INTO member(name) VALUES (?)";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);

			// le 1 correspond au rang du point d'interrogation (on pourrait en mettre
			// plusieurs)
			declaration.setString(1, name);

			int executeUpdate = declaration.executeUpdate();
			if (executeUpdate == 1) {
				System.out.println("insertion nom effectué ! ");
			} else {
				System.out.println("insertion nom non effectue");
			}
		} catch (Exception e) {
			System.err.println("Erreur d'insertion nom: " + e.getMessage());
		}
		return flag;
	}
	
}


