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

import com.xworkz.assignment.constants.EnumUtil;
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
		System.out.println("created : " + this.getClass().getSimpleName());
	}

	@RequestMapping(value = "/createAssignment", method = RequestMethod.GET)
	public ModelAndView onCreateAssignment(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			AdminEntity admin = (AdminEntity) session.getAttribute("admin");
			return new ModelAndView(EnumUtil.CreateAssignment.toString()).addObject("admin", admin);
		}
		return new ModelAndView(EnumUtil.SignIn.toString());
	}

	@RequestMapping(value = "/createAssignment", method = RequestMethod.POST)
	public ModelAndView onCreateAssignment(CreateAssignmentDTO createAssignmentDTO, HttpServletRequest request)
			throws ControllerException {

		HttpSession session = request.getSession(false);
		if (session != null) {
			try {
				AdminEntity adminEntity = (AdminEntity) session.getAttribute("admin");
				String assignmentId = iCreateAssignentService.createAssignment(adminEntity.getEmailId(),
						createAssignmentDTO);
				System.out.println("created id : " + assignmentId);
				return new ModelAndView(EnumUtil.CreateAssignment.toString(), "assignmentId",
						"Created Assignment id " + assignmentId);
			} catch (ServiceException e) {
				logger.error(e.getMessage());
				throw new ControllerException(e.getMessage());
			} catch (Exception e) {
				throw new ControllerException(e.getMessage());
			}
		} else {
			return new ModelAndView(EnumUtil.SignIn.toString());
		}
	}

}
