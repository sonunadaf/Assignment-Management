package com.xworkz.assignment.service.upload;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.xworkz.assignment.constants.ExceptionConstant;
import com.xworkz.assignment.dao.getcreatedassignmentbypin.GetCreatedAssignmentByPin;
import com.xworkz.assignment.dao.upload.UploadAssignmentStudentDAO;
import com.xworkz.assignment.dto.studentupload.UploadStudentAssignmentDTO;
import com.xworkz.assignment.entity.createassignment.CreateAssignmentEntity;
import com.xworkz.assignment.entity.upload.UploadStudentAssignmentEntity;
import com.xworkz.assignment.exception.DAOException;
import com.xworkz.assignment.exception.ServiceException;
import com.xworkz.assignment.mailsender.uploaduser.UploadedAssignmentStudent;

@Service
public class UploadStudentAssignmentServiceImpl implements UploadStudentAssignmentService {

	@Autowired
	private GetCreatedAssignmentByPin getCreatedAssignmentByPin;
	@Autowired
	private UploadAssignmentStudentDAO assignmentStudentDAO;
	@Autowired
	private UploadedAssignmentStudent uploadedAssignmentStudent;
	private static Logger logger = LoggerFactory.getLogger(UploadStudentAssignmentServiceImpl.class);

	@Override
	public boolean uploadAssignment(UploadStudentAssignmentDTO studentAssignmentDTO, String ipAddress)
			throws ServiceException {

		boolean status = false;
		try {
			UploadStudentAssignmentEntity studentAssignmentEntity = new UploadStudentAssignmentEntity();
			BeanUtils.copyProperties(studentAssignmentDTO, studentAssignmentEntity);
			studentAssignmentEntity.setDate(new SimpleDateFormat("YYYY-MM-DD HH:MM:SS").format(new Date()));
			studentAssignmentEntity.setIpAddress(ipAddress);
			MultipartFile file = studentAssignmentDTO.getFile();
			if (file != null) {
				String fileUrl = assignmentStudentDAO.saveFile(studentAssignmentDTO);
				logger.info("File path of save file is : " + fileUrl);
				studentAssignmentEntity.setUploadFilePath(fileUrl);
			}
			status = assignmentStudentDAO.saveStudentUpload(studentAssignmentEntity);
			if (status) {
				uploadedAssignmentStudent.sendMailtoStudent(studentAssignmentEntity.getEmailId());
			}

		} catch (Exception e) {
			logger.error(ExceptionConstant.EXCEPTION_FROM_SERVICE + this.getClass().getSimpleName() + e.getMessage());
			throw new ServiceException(
					ExceptionConstant.EXCEPTION_FROM_SERVICE + this.getClass().getSimpleName() + e.getMessage());
		}

		return status;
	}

	@Override
	public boolean isAssignmentPinAvailable(Integer pin, String email) throws ServiceException {
		try {
			if (pin != null) {

				CreateAssignmentEntity createAssignmentEntity = getCreatedAssignmentByPin.getCreatedAssignment(pin,
						email);
				if (createAssignmentEntity != null) {

					return true;
				} else {
					return false;
				}

			}
		} catch (DAOException e) {
			logger.error(ExceptionConstant.EXCEPTION_FROM_SERVICE + this.getClass().getSimpleName() + e.getMessage());
			throw new ServiceException(
					ExceptionConstant.EXCEPTION_FROM_SERVICE + this.getClass().getSimpleName() + e.getMessage());
		} catch (Exception e) {
			logger.error(ExceptionConstant.EXCEPTION_FROM_SERVICE + this.getClass().getSimpleName() + e.getMessage());
			throw new ServiceException(
					ExceptionConstant.EXCEPTION_FROM_SERVICE + this.getClass().getSimpleName() + e.getMessage());
		}
		return true;
	}

	@Override
	public boolean isStudentUploaded(Integer pin, String email) throws ServiceException {
		try {
			boolean status = assignmentStudentDAO.isStudentExist(pin, email);
			if (status) {
				return true;
			}

		} catch (DAOException e) {
			logger.error(ExceptionConstant.EXCEPTION_FROM_SERVICE + this.getClass().getSimpleName() + e.getMessage());
			throw new ServiceException(
					ExceptionConstant.EXCEPTION_FROM_SERVICE + this.getClass().getSimpleName() + e.getMessage());
		} catch (Exception e) {
			logger.error(ExceptionConstant.EXCEPTION_FROM_SERVICE + this.getClass().getSimpleName() + e.getMessage());
			throw new ServiceException(
					ExceptionConstant.EXCEPTION_FROM_SERVICE + this.getClass().getSimpleName() + e.getMessage());
		}
		return false;
	}
}
