package com.xworkz.assignment.controller.upload;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.assignment.constants.EnumUtil;
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

	@RequestMapping(value = "/uploadAssignment", method = RequestMethod.POST)
	public ModelAndView uploadAssignment(UploadStudentAssignmentDTO studentAssignmentDTO, HttpServletRequest request)
			throws ControllerException {
		try {
			if (studentAssignmentDTO != null) {

				boolean pinstatus = uploadStudent.isAssignmentPinAvailable(studentAssignmentDTO.getPin());
				if (pinstatus) {
					uploadStudent.uploadAssignment(studentAssignmentDTO, request.getRemoteAddr());
					System.err.println(studentAssignmentDTO);
					return new ModelAndView(EnumUtil.Upload.toString(), "msg", "upload successful");
				} else {
					return new ModelAndView(EnumUtil.Upload.toString(), "msg", "Enter a valid pin");
				}

			}
		} catch (

		ServiceException e) {
			logger.error("Exception from UploadStudentAssignmentController" + e.getMessage());
			throw new ControllerException(e.getMessage());

		} catch (Exception e) {
			logger.error("Exception from UploadStudentAssignmentController" + e.getMessage());
			throw new ControllerException(e.getMessage());

		}
		return new ModelAndView(EnumUtil.Upload.toString());
	}

}
