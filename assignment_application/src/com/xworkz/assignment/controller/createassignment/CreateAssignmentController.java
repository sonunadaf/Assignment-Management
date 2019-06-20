package com.xworkz.assignment.controller.createassignment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.xworkz.assignment.dto.createassignment.CreateAssignmentDTO;
import com.xworkz.assignment.entity.admin.AdminEntity;
import com.xworkz.assignment.exception.ControllerException;
import com.xworkz.assignment.exception.ServiceException;
import com.xworkz.assignment.service.createassignment.ICreateAssignentService;

@Controller
@RequestMapping("/")
public class CreateAssignmentController {

	@Autowired
	private ICreateAssignentService iCreateAssignentService;
	private static Logger logger = LoggerFactory.getLogger(CreateAssignmentController.class);

	public CreateAssignmentController() { 
	}

	@RequestMapping(value = "/createAssignment", method = RequestMethod.GET)
	public ModelAndView onCreateAssignment(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session.getAttribute(ViewMessageConstant.SESSION_USER) != null) {
			AdminEntity admin = (AdminEntity) session.getAttribute(ViewMessageConstant.SESSION_USER);
			return new ModelAndView(EnumViews.CreateAssignment.toString()).addObject(ViewMessageConstant.SESSION_USER,
					admin);
		}
		return new ModelAndView(EnumViews.SignIn.toString());
	}

	@RequestMapping(value = "/createAssignment", method = RequestMethod.POST)
	public ModelAndView onCreateAssignment(CreateAssignmentDTO createAssignmentDTO, HttpServletRequest request)
			throws ControllerException {

		HttpSession session = request.getSession(false);
		if (session.getAttribute(ViewMessageConstant.SESSION_USER) != null) {
			try {
				AdminEntity adminEntity = (AdminEntity) session.getAttribute(ViewMessageConstant.SESSION_USER);
				String assignmentId = iCreateAssignentService.createAssignment(adminEntity.getEmailId(),
						createAssignmentDTO);
				return new ModelAndView(EnumViews.CreateAssignment.toString(), ViewMessageConstant.ASSIGNMENT_ID,
						ViewMessageConstant.ASSIGNMENT_CREATED_MSG + assignmentId);
			} catch (ServiceException e) {
				logger.error(
						ExceptionConstant.EXCEPTION_FROM_CONTROLLER + this.getClass().getSimpleName() + e.getMessage());
				throw new ControllerException(
						ExceptionConstant.EXCEPTION_FROM_CONTROLLER + this.getClass().getSimpleName() + e.getMessage());
			} catch (Exception e) {
				throw new ControllerException(
						ExceptionConstant.EXCEPTION_FROM_CONTROLLER + this.getClass().getSimpleName() + e.getMessage());
			}
		} else {
			return new ModelAndView(EnumViews.SignIn.toString());
		}
	}

}
