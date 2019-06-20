package com.xworkz.assignment.controller.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.assignment.constants.EnumViews;
import com.xworkz.assignment.constants.ExceptionConstant;
import com.xworkz.assignment.constants.ViewMessageConstant;
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
	}

	@RequestMapping(value = "/adminSignUp", method = RequestMethod.GET)
	public String onSignUp() {

		return EnumViews.SignUp.toString();
	}

	@RequestMapping(value = "/adminSignUp", method = RequestMethod.POST)
	public ModelAndView onSignUp(SignUpDTO signUpDTO, Model model) throws ControllerException {
		String message = "";
		AdminEntity adminEntity = null;
		MemberEntity member = null;
		try {
			if (signUpDTO != null) {
				adminEntity = iSignUpService.getAdminEntityByEmail(signUpDTO.getEmailId());
				member = iSignUpService.getMemberEntity(signUpDTO.getEmailId());
			}
			if (member != null) {
				if (signUpDTO.getFirstName().length() <= 3) {
					return new ModelAndView(EnumViews.SignUp.toString(), ViewMessageConstant.MESSAGE,
							ViewMessageConstant.FIRST_NAME_LENGTH);
				} else if (signUpDTO.getPhoneNo().length() != 10) {
					return new ModelAndView(EnumViews.SignUp.toString(), ViewMessageConstant.MESSAGE,
							ViewMessageConstant.MOBILE_NO_LENGTH);
				} else if (adminEntity != null) {
					return new ModelAndView(EnumViews.SignUp.toString(), ViewMessageConstant.MESSAGE,
							ViewMessageConstant.EMAIL_EXIST_MSG);
				} else {
					message = iSignUpService.signUp(signUpDTO);
				}
			} else {
				return new ModelAndView(EnumViews.SignUp.toString(), ViewMessageConstant.MEMBER_ERROR,
						ViewMessageConstant.MEMBER_MSG);
			}
		} catch (ServiceException e) {
			System.err.println(
					ExceptionConstant.EXCEPTION_FROM_CONTROLLER + this.getClass().getSimpleName() + e.getMessage());
			throw new ControllerException(
					ExceptionConstant.EXCEPTION_FROM_CONTROLLER + this.getClass().getSimpleName() + e.getMessage());
		}
		return new ModelAndView(EnumViews.SignIn.toString(), ViewMessageConstant.MESSAGE, message);
	}
}
