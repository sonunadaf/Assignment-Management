package com.xworkz.assignment.dto.studentupload;

import org.springframework.web.multipart.MultipartFile;

public class UploadStudentAssignmentDTO {

	private String emailId;
	private Integer pin;
	private String gitUrl;
	private MultipartFile file;

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

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getGitUrl() {
		return gitUrl;
	}

	public void setGitUrl(String gitUrl) {
		this.gitUrl = gitUrl;
	}

	@Override
	public String toString() {
		return "UploadStudentAssignmentDTO [emailId=" + emailId + ", pin=" + pin + ", gitUrl=" + gitUrl + ", file="
				+ file + "]";
	}

}
