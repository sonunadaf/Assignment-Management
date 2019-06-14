package com.xworkz.assignment.dao.upload;

import com.xworkz.assignment.dto.studentupload.UploadStudentAssignmentDTO;
import com.xworkz.assignment.entity.upload.UploadStudentAssignmentEntity;
import com.xworkz.assignment.exception.DAOException;

public interface UploadAssignmentStudentDAO {
	public String saveFile(UploadStudentAssignmentDTO studentAssignmentDTO) throws DAOException;

	public boolean saveStudentUpload(UploadStudentAssignmentEntity studentAssignmentEntity) throws DAOException;
}
