package com.xworkz.assignment.controller.signin;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xworkz.assignment.dto.signin.SignInDTO;

@Controller
@RequestMapping("/")
public class SignInController {

	public SignInController() {
		System.out.println("created : " + this.getClass().getSimpleName());
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String signIn(Model model) {
		model.addAttribute("message", new SignInDTO());
		return "";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String signIn(@Valid @ModelAttribute("signInDTO") SignInDTO signInDTO, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "/LogIn.jsp";
		}

		return "/Index.jsp";
	}

}
