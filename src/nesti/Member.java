package nesti;

public class Member {
	int idMember;
	String lastName;
	String firstName;
	String alias;
	String email;
	String town;
	String password;

	/**
	 * Constructor for inscription
	 * 
	 * @param lastName
	 * @param firstName
	 * @param alias
	 * @param email
	 * @param town
	 * @param password
	 */
	public Member(String lastName, String firstName, String alias, String email, String town, String password) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.alias = alias;
		this.email = email;
		this.town = town;
		this.password = password;
	}

	/**
	 * constructor for login
	 * 
	 * @param email
	 * @param password
	 */
	public Member(String email, String password) {
		this.email = email;
		this.password = password;
	}

	/*
	 * public Member() { // TODO Auto-generated constructor stub }
	 */
	public String toString() {
		return "id : " + this.idMember + " nom : " + this.lastName + " prenom : " + this.firstName + " alias: " + alias
				+ " email : " + this.email + " ville : " + this.town + "password : " + this.password;
	}

	/**
	 * @return the id_member
	 */
	public int getIdMember() {
		return idMember;
	}

	/**
	 * @param id_member the id_member to set
	 */
	public void setIdMember(int id_member) {
		this.idMember = id_member;
	}

	/**
	 * @return the last_name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param last_name the last_name to set
	 */
	public void setLastName(String last_name) {
		this.lastName = last_name;
	}

	/**
	 * @return the first_name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param first_name the first_name to set
	 */
	public void setFirstName(String first_name) {
		this.firstName = first_name;
	}

	/**
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * @param alias the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the town
	 */
	public String getTown() {
		return town;
	}

	/**
	 * @param town the town to set
	 */
	public void setTown(String town) {
		this.town = town;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
