package com.xworkz.assignment.controller.signin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.assignment.constants.EnumUtil;
import com.xworkz.assignment.dto.signin.SignInDTO;
import com.xworkz.assignment.service.signin.ISignInService;

@Controller
@RequestMapping("/")
public class SignInController {

	@Autowired
	private ISignInService signInService;

	public SignInController() {
		System.out.println("created : " + this.getClass().getSimpleName());
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String signIn() {
		return EnumUtil.SignIn.toString();
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView signIn(SignInDTO signInDTO) {
		if (signInDTO != null) {
			boolean isexist = signInService.signIn(signInDTO);
			if (isexist)
				return new ModelAndView(EnumUtil.SignIn.toString(), "message", "Login successful");
		}
		return new ModelAndView(EnumUtil.SignIn.toString(), "message", "incorrect user name or password");

	}

}
