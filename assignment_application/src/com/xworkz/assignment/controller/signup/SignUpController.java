package com.xworkz.assignment.controller.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.assignment.dto.signup.SignUpDTO;
import com.xworkz.assignment.exception.ControllerException;
import com.xworkz.assignment.exception.ServiceException;
import com.xworkz.assignment.service.signup.ISignUpService;

@Controller
@RequestMapping("/")
public class SignUpController {

	@Autowired
	private ISignUpService iSignUpService;

	public SignUpController() {
		System.out.println("created : " + this.getClass().getSimpleName());
	}

	@RequestMapping(value = "/adminSignUp", method = RequestMethod.GET)
	public String onSignUp() {

		return "/SignUp.jsp";
	}

	@RequestMapping(value = "/adminSignUp", method = RequestMethod.POST)
	public ModelAndView onSignUp(SignUpDTO signUpDTO, Model model) throws ControllerException {
		String message = "";
		try {
			System.out.println(signUpDTO);
			message = iSignUpService.signUp(signUpDTO);

		} catch (ServiceException e) {
			System.err.println("Exception from controller" + e.getMessage());
			throw new ControllerException("Exception from controller " + e.getMessage());
		}
		return new ModelAndView("SignUp.jsp", "message", message);
	}
}
