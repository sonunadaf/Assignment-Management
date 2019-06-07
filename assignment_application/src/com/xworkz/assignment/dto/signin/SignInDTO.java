package com.xworkz.assignment.dto.signin;

public class SignInDTO {

	private String user;
	private String password;

	public SignInDTO() {
		System.out.println("Created : " + this.getClass().getSimpleName());
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "SignInDTO [user=" + user + ", password=" + password + "]";
	}

}
