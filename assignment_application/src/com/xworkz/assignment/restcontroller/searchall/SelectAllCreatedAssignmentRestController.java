package com.xworkz.assignment.restcontroller.searchall;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xworkz.assignment.constants.ViewMessageConstant;
import com.xworkz.assignment.entity.admin.AdminEntity;
import com.xworkz.assignment.entity.createassignment.CreateAssignmentEntity;
import com.xworkz.assignment.exception.ControllerException;
import com.xworkz.assignment.exception.ServiceException;
import com.xworkz.assignment.restservice.searchall.ISearchAllServiceRestController;

@RestController
public class SelectAllCreatedAssignmentRestController {

	@Autowired
	private ISearchAllServiceRestController allServiceRestController;

	@GetMapping(value = "/searchAll")
	public List<CreateAssignmentEntity> getAllSearch(HttpServletRequest request) throws ControllerException {
		List<CreateAssignmentEntity> list = null;
		try {
			HttpSession session = request.getSession();
			if (session.getAttribute(ViewMessageConstant.SESSION_USER) != null) {
				AdminEntity admin = (AdminEntity) session.getAttribute(ViewMessageConstant.SESSION_USER);
				list = allServiceRestController.getAllAssignmentEntities(admin.getEmailId());

			}
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		} catch (Exception e) {
			throw new ControllerException(e.getMessage());
		}

		return list;

	}
}
