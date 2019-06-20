package com.xworkz.assignment.restcontroller.getemail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.xworkz.assignment.constants.ExceptionConstant;
import com.xworkz.assignment.constants.ViewMessageConstant;
import com.xworkz.assignment.dao.getadminentitybyemail.GetAdminEntityByEmailDAOImpl;
import com.xworkz.assignment.exception.DAOException;

@RestController
public class GetEmailRestController {

	@Autowired
	private GetAdminEntityByEmailDAOImpl getIdByEmail;

	@GetMapping(value = "/email/{emailid}")
	public Boolean getEmail(@PathVariable String emailid, HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		try {
			if (session.getAttribute(ViewMessageConstant.SESSION_USER) != null)
				if (getIdByEmail.getEntityByEmail(emailid) != null) {

					return true;
				}
		} catch (DAOException e) {
			System.out.println(
					ExceptionConstant.EXCEPTION_FROM_CONTROLLER + this.getClass().getSimpleName() + e.getMessage());
		}
		return false;
	}
}
