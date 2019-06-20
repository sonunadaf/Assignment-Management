package com.xworkz.assignment.controller.upload;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.assignment.constants.EnumViews;
import com.xworkz.assignment.constants.ExceptionConstant;
import com.xworkz.assignment.constants.ViewMessageConstant;
import com.xworkz.assignment.dto.studentupload.UploadStudentAssignmentDTO;
import com.xworkz.assignment.exception.ControllerException;
import com.xworkz.assignment.exception.ServiceException;
import com.xworkz.assignment.service.upload.UploadStudentAssignmentService;

@Controller
@RequestMapping("/")
public class UploadStudentAssignmentController {

	@Autowired
	private UploadStudentAssignmentService uploadStudent;
	private static Logger logger = LoggerFactory.getLogger(UploadStudentAssignmentController.class);

	public UploadStudentAssignmentController() {

	}

	@RequestMapping(value = "/uploadAssignment", method = RequestMethod.POST)
	public ModelAndView uploadAssignment(UploadStudentAssignmentDTO studentAssignmentDTO, HttpServletRequest request)
			throws ControllerException {
		try {
			if (studentAssignmentDTO != null) {

				boolean pinstatus = uploadStudent.isAssignmentPinAvailable(studentAssignmentDTO.getPin(),
						studentAssignmentDTO.getEmailId());
				if (pinstatus) {
					boolean uploadStstus = uploadStudent.isStudentUploaded(studentAssignmentDTO.getPin(),
							studentAssignmentDTO.getEmailId());
					if (!uploadStstus) {
						uploadStudent.uploadAssignment(studentAssignmentDTO, request.getRemoteAddr());
						return new ModelAndView(EnumViews.Upload.toString(), ViewMessageConstant.MSG,
								ViewMessageConstant.UPLOAD_SUCCESSFUL);
					} else {
						return new ModelAndView(EnumViews.Upload.toString(), ViewMessageConstant.MSG,
								ViewMessageConstant.ALREADY_UPLOADED);
					}

				} else {
					return new ModelAndView(EnumViews.Upload.toString(), ViewMessageConstant.MSG,
							ViewMessageConstant.INCORRECT_ASSIGNMENT_PIN);
				}

			}
		} catch (

		ServiceException e) {
			logger.error(
					ExceptionConstant.EXCEPTION_FROM_CONTROLLER + this.getClass().getSimpleName() + e.getMessage());
			throw new ControllerException(
					ExceptionConstant.EXCEPTION_FROM_CONTROLLER + this.getClass().getSimpleName() + e.getMessage());

		} catch (Exception e) {
			logger.error(
					ExceptionConstant.EXCEPTION_FROM_CONTROLLER + this.getClass().getSimpleName() + e.getMessage());
			throw new ControllerException(
					ExceptionConstant.EXCEPTION_FROM_CONTROLLER + this.getClass().getSimpleName() + e.getMessage());

		}
		return new ModelAndView(EnumViews.Upload.toString());
	}

}
