package com.xworkz.assignment.controller.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.assignment.constants.EnumUtil;
import com.xworkz.assignment.dto.signup.SignUpDTO;
import com.xworkz.assignment.entity.admin.AdminEntity;
import com.xworkz.assignment.entity.member.MemberEntity;
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

		return EnumUtil.SignUp.toString();
	}

	@RequestMapping(value = "/adminSignUp", method = RequestMethod.POST)
	public ModelAndView onSignUp(SignUpDTO signUpDTO, Model model) throws ControllerException {
		String message = "";
		AdminEntity adminEntity = null;
		MemberEntity member = null;
		System.out.println(signUpDTO);
		try {
			if (signUpDTO != null) {
				adminEntity = iSignUpService.getAdminEntityByEmail(signUpDTO.getEmailId());
				member = iSignUpService.getMemberEntity(signUpDTO.getEmailId());
			}
			if (member != null) {
				if (signUpDTO.getFirstName().length() <= 3) {
					return new ModelAndView(EnumUtil.SignUp.toString(), "message",
							"First name must be more than 4 character");
				} else if (signUpDTO.getPhoneNo().length() != 10) {
					return new ModelAndView(EnumUtil.SignUp.toString(), "message", "Mobile Number must be 10 digit");
				} else if (adminEntity != null) {
					return new ModelAndView(EnumUtil.SignUp.toString(), "message", "Email already Exist");
				} else {
					message = iSignUpService.signUp(signUpDTO);
				}
			} else {
				return new ModelAndView(EnumUtil.SignUp.toString(), "membererror",
						"You are not member of our team please contact to Assignment Management team");
			}
		} catch (ServiceException e) {
			System.err.println("Exception from controller" + e.getMessage());
			throw new ControllerException("Exception from controller " + e.getMessage());
		}
		return new ModelAndView("SignIn", "message", message);
	}
}
