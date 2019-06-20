package com.xworkz.assignment.controller.signin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.assignment.constants.EnumViews;
import com.xworkz.assignment.constants.ExceptionConstant;
import com.xworkz.assignment.constants.ViewMessageConstant;
import com.xworkz.assignment.dto.signin.SignInDTO;
import com.xworkz.assignment.entity.admin.AdminEntity;
import com.xworkz.assignment.exception.ControllerException;
import com.xworkz.assignment.exception.DAOException;
import com.xworkz.assignment.exception.ServiceException;
import com.xworkz.assignment.service.signin.ISignInService;

@Controller
@RequestMapping("/")
public class SignInController {

	@Autowired
	private ISignInService signInService;

	public SignInController() {
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String signIn() {
		return EnumViews.SignIn.toString();
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView signIn(SignInDTO signInDTO, HttpServletRequest request)
			throws DAOException, ControllerException {

		if (signInDTO != null) {
			AdminEntity getAdminFromDb; 
			try {
				getAdminFromDb = signInService.signIn(signInDTO);

				if (getAdminFromDb != null) {
					if (signInDTO.getPassword().equals(getAdminFromDb.getPassword())) {
						if (getAdminFromDb.getFailLogin() < 3) {
							signInService.updateFailLoginByZero(getAdminFromDb);
							HttpSession session = request.getSession(true);
							session.setMaxInactiveInterval(60 * 10);
							session.setAttribute(ViewMessageConstant.SESSION_USER, getAdminFromDb);
							if (getAdminFromDb.isFirstLogin()) {
								return new ModelAndView(EnumViews.ChangePassword.toString(),
										ViewMessageConstant.MESSAGE, ViewMessageConstant.SIGNIN_SUCCESS);
							} else {
								return new ModelAndView(EnumViews.CreateAssignment.toString());
							}
						} else {
							return new ModelAndView(EnumViews.SignIn.toString(), ViewMessageConstant.MESSAGE,
									ViewMessageConstant.WRONG_PASSWORD_3_TIMES);
						}

					} else {
						signInService.updateFailLogin(getAdminFromDb);
						return new ModelAndView(EnumViews.SignIn.toString(), ViewMessageConstant.MESSAGE,
								ViewMessageConstant.INCORRECT_PASSWORD);
					}
				} else {
					return new ModelAndView(EnumViews.SignIn.toString(), ViewMessageConstant.MESSAGE,
							ViewMessageConstant.INCORRECT_USER_NAME);
				}
			} catch (ServiceException e) {
				throw new ControllerException(
						ExceptionConstant.EXCEPTION_FROM_CONTROLLER + this.getClass().getSimpleName() + e.getMessage());
			} catch (Exception e) {
				throw new ControllerException(
						ExceptionConstant.EXCEPTION_FROM_CONTROLLER + this.getClass().getSimpleName() + e.getMessage());
			}
		} else {

			return new ModelAndView(EnumViews.SignIn.toString(), ViewMessageConstant.MESSAGE,
					ViewMessageConstant.INCORRECT_USER_NAME);
		}

	}
}
