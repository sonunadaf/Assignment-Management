package com.xworkz.assignment.controller.signin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.assignment.constants.EnumUtil;
import com.xworkz.assignment.dto.signin.SignInDTO;
import com.xworkz.assignment.entity.admin.AdminEntity;
import com.xworkz.assignment.exception.DAOException;
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
	public ModelAndView signIn(SignInDTO signInDTO) throws DAOException {

		System.out.println("invoked signin from controller " + signInDTO);
		if (signInDTO != null) {
			AdminEntity getAdminFromDb = signInService.signIn(signInDTO);
			if (getAdminFromDb != null) {
				if (signInDTO.getPassword().equals(getAdminFromDb.getPassword())) {
					if (getAdminFromDb.getFailLogin() < 3) {
						signInService.updateFailLoginByZero(getAdminFromDb);
						return new ModelAndView(EnumUtil.SignIn.toString(), "message", "Sign Successful");
					} else {
						return new ModelAndView(EnumUtil.SignIn.toString(), "message",
								"You have have entered 3 time wrong password,  please contact Assignment Mannagement Customer Care");
					}

				} else {
					signInService.updateFailLogin(getAdminFromDb);
					return new ModelAndView(EnumUtil.SignIn.toString(), "message", "incorrect user password");
				}
			} else {
				return new ModelAndView(EnumUtil.SignIn.toString(), "message", "incorrect user name");
			}
		} else {

			return new ModelAndView(EnumUtil.SignIn.toString(), "message", "incorrect user name");
		}

	}
}
