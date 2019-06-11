package com.xworkz.assignment.dto.settings;

public class SettingsDTO {

	private String firstName;
	private String lastName;
	private String email;
	private String phoneNUmber;
	private String ipAddress;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNUmber() {
		return phoneNUmber;
	}

	public void setPhoneNUmber(String phoneNUmber) {
		this.phoneNUmber = phoneNUmber;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@Override
	public String toString() {
		return "SettingsDTO [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNUmber="
				+ phoneNUmber + ", ipAddress=" + ipAddress + "]";
	}

}
