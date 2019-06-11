package com.xworkz.assignment.restcontroller.search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xworkz.assignment.entity.admin.AdminEntity;
import com.xworkz.assignment.entity.createassignment.CreateAssignmentEntity;
import com.xworkz.assignment.exception.ControllerException;
import com.xworkz.assignment.exception.ServiceException;
import com.xworkz.assignment.restservice.search.SearchRestService;

@RestController
@RequestMapping("/")
public class SearchRestController {

	@Autowired
	private SearchRestService searchRestService;

	@GetMapping(value = "/search/{assignmentPin}")
	public CreateAssignmentEntity search(@PathVariable Integer assignmentPin, HttpServletRequest request)
			throws ControllerException {

		System.err.println("Invoked Search rest Controller by id " + assignmentPin);

		CreateAssignmentEntity assignmentEntity = null;
		try {
			HttpSession session = request.getSession(false);
			if (session != null) {
				AdminEntity admin = (AdminEntity) session.getAttribute("admin");
				System.err.println("admin email from rest: " + admin.getEmailId());

				assignmentEntity = searchRestService.getCreatedAssignment(admin.getEmailId(), assignmentPin);
				System.out.println(assignmentEntity);

			}
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new ControllerException(e.getMessage());
		}

		return assignmentEntity;

	}

}
