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
		createMember();
	}

	public static void readAll() {
		try {
			Statement declaration = accessDataBase.createStatement();
			String query = "SELECT * FROM `member`";
			ResultSet resultat = declaration.executeQuery(query);

			/* Récupération des données */
			while (resultat.next()) {
				Member member = new Member();
				member.setIdMember(resultat.getInt("id_member"));
				member.setLastName(resultat.getString("last_name"));
				member.setFirstName(resultat.getString("first_name"));
				member.setAlias(resultat.getString("alias"));
				member.setEmail(resultat.getString("email"));
				member.setTown(resultat.getString("town"));
				member.setPassword(resultat.getString("password"));
				
				System.out.println(member.toString());
			}

		} catch (Exception e) {
			System.err.println("Erreur d'affichage du membre : " + e.getMessage());
		}

	}

	/**
	 * insert member into database
	 * @param name
	 * @return flag
	 */
	public static boolean createMember() {
		try {
			String query = "INSERT INTO `member`(last_name,first_name,alias,email,town,password) VALUES (?,?,?,?,?,?)";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			Member member = new Member();
			// le 1 correspond au rang du point d'interrogation (on pourrait en mettre
			// plusieurs)
			
			declaration.setString(1, member.getLastName());
			declaration.setString(2, member.getFirstName());
			declaration.setString(3, member.getAlias());
			declaration.setString(4, member.getEmail());
			declaration.setString(5, member.getTown());
			declaration.setString(6, member.getPassword());
			
			int executeUpdate = declaration.executeUpdate();
			if (executeUpdate == 1) {
				System.out.println("insertion membre effectué ! ");
			} else {
				System.out.println("insertion membre non effectue");
			}
		} catch (Exception e) {
			System.err.println("Erreur d'insertion du membre: " + e.getMessage());
		}
		return flag;
	}
	
}


