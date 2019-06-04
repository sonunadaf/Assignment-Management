package com.xworkz.assignment.restcontroller.getemail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.xworkz.assignment.dao.getadminentitybyemail.GetAdminEntityByEmailDAOImpl;
import com.xworkz.assignment.exception.DAOException;

@RestController
public class GetEmailRestController {

	@Autowired
	private GetAdminEntityByEmailDAOImpl getIdByEmail;

	@GetMapping(value = "/email/{emailid}")
	public Boolean getEmail(@PathVariable String emailid) {
		System.out.println(emailid);
		try {
			if (getIdByEmail.getEntityByEmail(emailid) != null) {

				return true;
			}
		} catch (DAOException e) {
			System.out.println("Exception from Web Controller " + e.getMessage());
		}
		return false;
	}
}
