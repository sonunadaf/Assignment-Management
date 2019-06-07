package com.xworkz.assignment.dto.changepassword;

import java.io.Serializable;

public class ChangePasswordDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String oldPassword;
	private String newPassword;
	private String confirmPassword;

	public ChangePasswordDTO() {
		System.out.println("created :" + this.getClass().getSimpleName());
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "ChangePasswordDTO [userName=" + userName + ", oldPassword=" + oldPassword + ", newPassword="
				+ newPassword + ", confirmPassword=" + confirmPassword + "]";
	}

}
