package com.xworkz.assignment.controller.createassignment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.assignment.constants.EnumUtil;
import com.xworkz.assignment.dto.createassignment.CreateAssignmentDTO;
import com.xworkz.assignment.entity.admin.AdminEntity;
import com.xworkz.assignment.service.createassignment.ICreateAssignentService;

@Controller
@RequestMapping("/")
public class CreateAssignmentController {

	@Autowired
	private ICreateAssignentService iCreateAssignentService;

	public CreateAssignmentController() {
		System.out.println("created : " + this.getClass().getSimpleName());
	}

	@RequestMapping(value = "/createAssignment", method = RequestMethod.GET)
	public ModelAndView onCreateAssignment(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {

		}
		return null;
	}

	@RequestMapping(value = "/createAssignment", method = RequestMethod.POST)
	public ModelAndView onCreateAssignment(CreateAssignmentDTO createAssignmentDTO, HttpServletRequest request) {
		System.out.println("createAssingment : " + createAssignmentDTO);
		HttpSession session = request.getSession(false);
		if (session != null) {
			AdminEntity adminEntity = (AdminEntity) session.getAttribute("admin");
			String assignmentId = iCreateAssignentService.createAssignment(adminEntity.getEmailId(),
					createAssignmentDTO);
			System.out.println("created id : " + assignmentId);
			return new ModelAndView(EnumUtil.CreateAssignment.toString(), "assignmentId",
					"Created Assignment id " + assignmentId);
		}
		return new ModelAndView(EnumUtil.SignIn.toString());
	}

}
