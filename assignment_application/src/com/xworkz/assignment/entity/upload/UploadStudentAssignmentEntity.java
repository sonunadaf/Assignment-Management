package com.xworkz.assignment.entity.upload;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "assignment_upload_by_student")
public class UploadStudentAssignmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "ASSIGNMENT_ID")
	private int uploadId;
	@Column(name = "EMAIL_ID")
	private String emailId;
	@Column(name = "PIN")
	private Integer pin;
	@Column(name = "GIT_URL")
	private String gitUrl;
	@Column(name = "UPLOAD_DATE")
	private String date;
	@Column(name = "IP_ADDRESS")
	private String ipAddress;
	@Column(name = "UPLOAD_FILE_PATH")
	private String uploadFilePath;

	public UploadStudentAssignmentEntity() {

	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Integer getPin() {
		return pin;
	}

	public void setPin(Integer pin) {
		this.pin = pin;
	}

	public String getGitUrl() {
		return gitUrl;
	}

	public void setGitUrl(String gitUrl) {
		this.gitUrl = gitUrl;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getUploadFilePath() {
		return uploadFilePath;
	}

	public void setUploadFilePath(String uploadFilePath) {
		this.uploadFilePath = uploadFilePath;
	}

	public int getUploadId() {
		return uploadId;
	}

	public void setUploadId(int uploadId) {
		this.uploadId = uploadId;
	}

	@Override
	public String toString() {
		return "UploadStudentAssignmentEntity [uploadId=" + uploadId + ", emailId=" + emailId + ", pin=" + pin
				+ ", gitUrl=" + gitUrl + ", date=" + date + ", ipAddress=" + ipAddress + ", uploadFilePath="
				+ uploadFilePath + "]";
	}

}
