package Entities;

public class credentialsC {
	private int idcredential, idemp;
	private String login, password, role;
	
	public credentialsC() {
	}
	
	public credentialsC(int idcredential, int idemp, String login, String password, String role) {
		super();
		this.idcredential = idcredential;
		this.idemp = idemp;
		this.login = login;
		this.password = password;
		this.role = role;
	}
	
	public int getIdcredential() {
		return idcredential;
	}
	public void setIdcredential(int idcredential) {
		this.idcredential = idcredential;
	}
	public int getIdemp() {
		return idemp;
	}
	public void setIdemp(int idemp) {
		this.idemp = idemp;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "credentialsC [idcredential=" + idcredential + ", idemp=" + idemp + ", login=" + login + ", password="
				+ password + ", role=" + role + "]";
	}


	

}



