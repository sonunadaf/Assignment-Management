package com.xworkz.assignment.service.upload;

import com.xworkz.assignment.dto.studentupload.UploadStudentAssignmentDTO;
import com.xworkz.assignment.exception.ServiceException;

public interface UploadStudentAssignmentService {

	public boolean uploadAssignment(UploadStudentAssignmentDTO studentAssignmentDTO, String ipAddress)
			throws ServiceException;

	public boolean isAssignmentPinAvailable(Integer pin, String email) throws ServiceException;

	public boolean isStudentUploaded(Integer pin, String email) throws ServiceException;

}
