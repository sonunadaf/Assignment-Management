package com.xworkz.assignment.restcontroller.signin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.xworkz.assignment.dto.signin.SignInDTO;
import com.xworkz.assignment.restservice.signin.ISignInRestService;

@RestController
public class SignInRestController {

	@Autowired
	private ISignInRestService signInRestService;

	@GetMapping("/userlogin/{email}")
	public SignInDTO getUserNameAndPassword(@PathVariable String email) {

		SignInDTO signInDTO = signInRestService.getSignInDTO(email);
		if (signInDTO != null) {
			return signInDTO;
		} else {
			return null;
		}
	}
}
