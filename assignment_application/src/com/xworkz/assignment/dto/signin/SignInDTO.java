package com.xworkz.assignment.dto.signin;

import javax.validation.constraints.NotEmpty;

public class SignInDTO {

	@NotEmpty(message = "enter user name")
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
}
