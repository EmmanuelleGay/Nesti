package nesti;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DalQuery extends MyConnexion {

	private boolean memberEmailIsOk;
	static boolean flag;

	/**
	 * print data of member
	 * 
	 * @param member
	 */

	/*
	 * public static void readAll(Member member) { try { Statement declaration =
	 * accessDataBase.createStatement(); String query = "SELECT * FROM `member`";
	 * ResultSet resultat = declaration.executeQuery(query);
	 * 
	 * // Récupération des données while (resultat.next()) {
	 * member.setIdMember(resultat.getInt("id_member"));
	 * member.setLastName(resultat.getString("last_name"));
	 * member.setFirstName(resultat.getString("first_name"));
	 * member.setAlias(resultat.getString("alias"));
	 * member.setEmail(resultat.getString("email"));
	 * member.setTown(resultat.getString("town"));
	 * 
	 * System.out.println(member.toString()); }
	 * 
	 * } catch (Exception e) { System.err.println("Erreur d'affichage du membre : "
	 * + e.getMessage()); }
	 * 
	 * }
	 */
	/**
	 * insert member into database
	 * 
	 * @param name
	 * @return flag
	 */
	public static boolean createMember(Member member, HashPassword hashPassword) {
		try {
			openConnection();

			String query = "INSERT INTO `member`(last_name,first_name,alias,email,town,password) VALUES (?,?,?,?,?,?)";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);

			declaration.setString(1, member.getLastName());
			declaration.setString(2, member.getFirstName());
			declaration.setString(3, member.getAlias());
			declaration.setString(4, member.getEmail());
			declaration.setString(5, member.getTown());
			declaration.setString(6, hashPassword.getHashPassword());

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

	public static boolean loginMember(String email, String pseudo) throws SQLException {
		ResultSet resultInfo = null;
		try {
			MyConnexion.openConnection();
			String query = "SELECT password, email, alias from `member` where email = ? or alias = ?";
			PreparedStatement declaration = MyConnexion.accessDataBase.prepareStatement(query);
			declaration.setString(1, email);
			declaration.setString(2, pseudo);

			resultInfo = declaration.executeQuery();
		} 
		catch (Exception e) {
			System.err.println("Erreur de récupération du login de l'utilisateur" + e.getMessage());
		}
		return resultInfo.next();
	}

	
	public static void selectIdMember(Member member) {

		try {
			MyConnexion.openConnection();

			String query = "SELECT id_member, last_name, first_name, alias, email, town from `member` where email = ?";
			PreparedStatement declaration = MyConnexion.accessDataBase.prepareStatement(query);
			declaration.setString(1, member.getEmail());

			ResultSet resultInfo = declaration.executeQuery();

			while (resultInfo.next()) {
				member.setIdMember(resultInfo.getInt("id_member"));
				member.setLastName(resultInfo.getString("last_name"));
				member.setFirstName(resultInfo.getString("first_name"));
				member.setAlias(resultInfo.getString("alias"));
				member.setEmail(resultInfo.getString("email"));
				member.setTown(resultInfo.getString("town"));
			}
		}

		catch (Exception e) {
			System.err.println("Erreur de récupération de l'ID du membre" + e.getMessage());

		}
	}

	public static boolean isEmailAlreadyExist(String email) throws SQLException {
		ResultSet resultInfo = null;
		try {
			MyConnexion.openConnection();
			String query = "SELECT email from `member` where email = ?";
			PreparedStatement declaration = MyConnexion.accessDataBase.prepareStatement(query);
			declaration.setString(1, email);

			resultInfo = declaration.executeQuery();

		}

		catch (Exception e) {
			System.err.println("Erreur de vérification de l'email" + e.getMessage());

		}
		return resultInfo.next();
	}

	public static boolean isAliasAlreadyExist(String alias) throws SQLException {
		ResultSet resultInfo = null;
		try {
			MyConnexion.openConnection();
			String query = "SELECT alias from `member` where alias = ?";
			PreparedStatement declaration = MyConnexion.accessDataBase.prepareStatement(query);
			declaration.setString(1, alias);

			resultInfo = declaration.executeQuery();

		}

		catch (Exception e) {
			System.err.println("Erreur de vérification du pseudo" + e.getMessage());

		}
		return resultInfo.next();
	}

	/*
	 * public void selectLoginMember(String email, String password) {
	 * 
	 * try { openConnection(); String query
	 * ="SELECT * from `member` where email = ? and password = ?"; PreparedStatement
	 * declaration = accessDataBase.prepareStatement(query);
	 * declaration.setString(1, email); declaration.setString(2, password);
	 * 
	 * ResultSet resultInfo = declaration.executeQuery();
	 * setMemberEmailIsOk(resultInfo.next());
	 * 
	 * System.out.println(resultInfo);
	 * 
	 * } catch (Exception e) {
	 * System.err.println("Erreur de récupération des informations du membre " +
	 * e.getMessage()); } }
	 */

	public static boolean updateMember(Member member, HashPassword hashPassword) {
		boolean success = false;
		try {
			openConnection();

			String query = "UPDATE `member` SET last_name = ?,first_name = ?,alias = ?,email = ?,town = ?,password = ?, update_date = now() where id_member = ?";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);

			declaration.setString(1, member.getLastName());
			declaration.setString(2, member.getFirstName());
			declaration.setString(3, member.getAlias());
			declaration.setString(4, member.getEmail());
			declaration.setString(5, member.getTown());
			declaration.setString(6, hashPassword.getHashPassword());

			// declaration.setTimestamp(7,
			// java.sql.Timestamp.from(java.time.Instant.now()));
			declaration.setInt(7, member.getIdMember());

			int executeUpdate = declaration.executeUpdate();
			if (executeUpdate == 1) {
				System.out.println("mise à jour du membre effectué ! ");
			} else {
				System.out.println("mise à jour du membre non effectue");
			}
		} catch (Exception e) {
			System.err.println("Erreur de mise à jour du membre: " + e.getMessage());
		}
		return success;

	}

	/**
	 * @return the memberEmailIsOk
	 */
	public boolean getIsMemberEmailIsOk() {
		return memberEmailIsOk;
	}

	/**
	 * @param memberEmailIsOk the memberEmailIsOk to set
	 */
	public void setMemberEmailIsOk(boolean memberEmailIsOk) {
		this.memberEmailIsOk = memberEmailIsOk;
	}
}
