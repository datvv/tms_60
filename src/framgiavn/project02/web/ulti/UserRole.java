package framgiavn.project02.web.ulti;

/**
 * @author nguyenanhvan
 *
 */
public enum UserRole {

	USER("ROLE_USER"), SUPERVISOR("ROLE_SUPERVISOR"), ADMIN("ROLE_ADMIN");
	
	private String role;

	private UserRole(String role) {
		this.setRole(role);
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String toString() {
		return this.getRole();
	}

}
