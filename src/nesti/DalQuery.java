package nesti;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import toolsControl.HashPassword;

public class DalQuery extends MyConnexion {

	static boolean flag;

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
			
		} catch (Exception e) {
			System.err.println("Erreur d'insertion du membre: " + e.getMessage());
		}
		return flag;
	}

	/**
	 * Fonction to check email and password of user
	 * 
	 * @param email
	 * @param pseudo
	 * @return resultNext
	 * @throws SQLException
	 */

	public static boolean loginMember(String email, String pseudo) throws SQLException {
		ResultSet resultInfo = null;
		try {
			openConnection();
			String query = "SELECT password, email, alias from `member` where email = ? or alias = ?";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			declaration.setString(1, email);
			declaration.setString(2, pseudo);

			resultInfo = declaration.executeQuery();
		} catch (Exception e) {
			System.err.println("Erreur de r�cup�ration du login de l'utilisateur" + e.getMessage());
		}
		return resultInfo.next();
	}

	/**
	 * Fonction to recover the id of the user
	 * 
	 * @param member
	 */
	public static void selectIdMember(Member member) {

		try {
			openConnection();

			String query = "SELECT id_member, last_name, first_name, alias, email, town from `member` where email = ?";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
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
			System.err.println("Erreur de r�cup�ration de l'ID du membre" + e.getMessage());

		}
	}

	/**
	 * Fonction to check if email already exist in db
	 * 
	 * @param email
	 * @return resultInfo
	 * @throws SQLException
	 */
	public static boolean isEmailAlreadyExist(String email) throws SQLException {
		ResultSet resultInfo = null;
		try {
			openConnection();
			String query = "SELECT email from `member` where email = ?";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			declaration.setString(1, email);

			resultInfo = declaration.executeQuery();

		}

		catch (Exception e) {
			System.err.println("Erreur de v�rification de l'email" + e.getMessage());

		}
		return resultInfo.next();
	}

	/**
	 * Fonction to check if Alias alreaydy exist in db
	 * 
	 * @param alias
	 * @return resultInfo
	 * @throws SQLException
	 */
	public static boolean isAliasAlreadyExist(String alias) throws SQLException {
		ResultSet resultInfo = null;
		try {
			openConnection();
			String query = "SELECT alias from `member` where alias = ?";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			declaration.setString(1, alias);

			resultInfo = declaration.executeQuery();

		}

		catch (Exception e) {
			System.err.println("Erreur de v�rification du pseudo" + e.getMessage());

		}
		return resultInfo.next();
	}

	/**
	 * Fonction which update the user's information into db
	 * 
	 * @param member
	 * @param hashPassword
	 * @return boolean
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
			declaration.setInt(7, member.getIdMember());

			int executeUpdate = declaration.executeUpdate();
			if (executeUpdate == 1) {
				System.out.println("mise � jour du membre effectu� ! ");
			} else {
				System.out.println("mise � jour du membre non effectue");
			}
		} catch (Exception e) {
			System.err.println("Erreur de mise � jour du membre: " + e.getMessage());
		}
		return success;

	}
}
