package com.xworkz.assignment.entity.admin;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ADMIN")
@NamedQueries({
		@NamedQuery(name = "isEmailExist", query = "select entity from AdminEntity entity where entity.emailId=:email") })
public class AdminEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "ID")
	private int id;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "EMAIL_ID")
	private String emailId;
	@Column(name = "COUNTRY_NAME")
	private String countryName;
	@Column(name = "CONTACT_NUMBER")
	private String contactNumber;
	@Column(name = "FIRST_LOGIN")
	private boolean isFirstLogin;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "SIGN_UP_DATE")
	private String date;
	@Column(name = "LAST_SIGN_IN")
	private String lastLogin;
	@Column(name = "FAIL_SIGN_IN")
	private Integer failLogin;
	@Column(name = "isOwner")
	private boolean isOwner;

	public AdminEntity() {
		System.out.println("created : " + this.getClass().getSimpleName());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public boolean isFirstLogin() {
		return isFirstLogin;
	}

	public void setFirstLogin(boolean isFirstLogin) {
		this.isFirstLogin = isFirstLogin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Integer getFailLogin() {
		return failLogin;
	}

	public void setFailLogin(int failLogin) {
		this.failLogin = failLogin;
	}

	public boolean isOwner() {
		return isOwner;
	}

	public void setOwner(boolean isOwner) {
		this.isOwner = isOwner;
	}

	public void setFailLogin(Integer failLogin) {
		this.failLogin = failLogin;
	}

	@Override
	public String toString() {
		return "AdminEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", countryName=" + countryName + ", contactNumber=" + contactNumber + ", isFirstLogin=" + isFirstLogin
				+ ", password=" + password + ", date=" + date + ", lastLogin=" + lastLogin + ", failLogin=" + failLogin
				+ ", isOwner=" + isOwner + "]";
	}

}
