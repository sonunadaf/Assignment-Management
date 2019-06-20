package com.xworkz.assignment.restcontroller.uploadedassignmentbystudent;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xworkz.assignment.entity.admin.AdminEntity;
import com.xworkz.assignment.exception.ControllerException;
import com.xworkz.assignment.exception.ServiceException;
import com.xworkz.assignment.service.getsolvedassignment.GetSolvedAssignmentByPinService;

@RestController
public class AssignmentUploadedStudentListRestController {

	@Autowired
	private GetSolvedAssignmentByPinService getSolvedAssignmentService;
	private static Logger logger = LoggerFactory.getLogger(AssignmentUploadedStudentListRestController.class);

	@GetMapping("/getUploadedList")
	public List getUploadedList(HttpServletRequest request) throws ControllerException {
		HttpSession session = request.getSession(false);
		List list = null; 
		try {
			if (session != null) {
				AdminEntity admin = (AdminEntity) session.getAttribute("admin");
				list = getSolvedAssignmentService.getSolvedAssignmentbyPin(admin.getEmailId());
			}
		} catch (ServiceException e) {
			logger.error("Exception from AssignmentUploadedStudentListRestController " + e.getMessage());
			throw new ControllerException(e.getMessage());
		}

		return list;
	}

}
