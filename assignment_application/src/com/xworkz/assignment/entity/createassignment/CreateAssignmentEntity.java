package com.xworkz.assignment.entity.createassignment;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "created_assignment")
public class CreateAssignmentEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name="auto",strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "ASSIGNMENT_ID")
	private Integer assignmentId;
	@Column(name = "COURSE_NAME")
	private String courseName;
	@Column(name = "TOPIC_NAME")
	private String topicName;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "LAST_DATE")
	private String lastDate;
	@Column(name = "UPLOAD_TYPE")
	private String uploadType;
	@Column(name = "CREATED_DATE")
	private String createdDate;
	@Column(name = "SOLVED_STUDENT_COUNT")
	private Integer solvedStudentCount;
	@Column(name = "EMAIL")
	private String email;

	public CreateAssignmentEntity() {
		// TODO Auto-generated constructor stub
		System.out.println("created : " + this.getClass().getSimpleName());
	}

	

	public Integer getAssignmentId() {
		return assignmentId;
	}



	public void setAssignmentId(Integer assignmentId) {
		this.assignmentId = assignmentId;
	}



	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLastDate() {
		return lastDate;
	}

	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}

	public String getUploadType() {
		return uploadType;
	}

	public void setUploadType(String uploadType) {
		this.uploadType = uploadType;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getSolvedStudentCount() {
		return solvedStudentCount;
	}

	public void setSolvedStudentCount(Integer solvedStudentCount) {
		this.solvedStudentCount = solvedStudentCount;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "CreateAssignmentEntity [assignmentId=" + assignmentId + ", courseName=" + courseName + ", topicName="
				+ topicName + ", description=" + description + ", lastDate=" + lastDate + ", uploadType=" + uploadType
				+ ", createdDate=" + createdDate + ", solvedStudentCount=" + solvedStudentCount + ", email=" + email
				+ "]";
	}

}
