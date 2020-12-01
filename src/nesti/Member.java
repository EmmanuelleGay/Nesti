package nesti;

public class Member {
	int id_member;
	String last_name;
	String first_name;
	String alias;
	String email;
	String town;
	String password;
	
	
	public String toString() {
		return "id : " + this.id_member + " nom : " + this.last_name + " prenom : " + this.first_name + " alias: " + alias + " email : " + this.email + " ville : " + this.town + "password : " + this.password ;
	}

	
	/**
	 * @return the id_member
	 */
	public int getId_member() {
		return id_member;
	}
	/**
	 * @param id_member the id_member to set
	 */
	public void setId_member(int id_member) {
		this.id_member = id_member;
	}
	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}
	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}
	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
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
