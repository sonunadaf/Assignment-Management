package com.xworkz.assignment.dto.createassignment;



public class CreateAssignmentDTO {

	private String courseName;
	private String topicName;
	private String description;
	private String lastDate;
	private String uploadType;

	public CreateAssignmentDTO() {
		System.out.println("created : " + this.getClass().getSimpleName());
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

	public String getUploadType() {
		return uploadType;
	}

	public void setUploadType(String uploadType) {
		this.uploadType = uploadType;
	}

	public String getLastDate() {
		return lastDate;
	}

	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}

	@Override
	public String toString() {
		return "CreateAssignmentDTO [courseName=" + courseName + ", topicName=" + topicName + ", description="
				+ description + ", lastDate=" + lastDate + ", uploadType=" + uploadType + "]";
	}

}
