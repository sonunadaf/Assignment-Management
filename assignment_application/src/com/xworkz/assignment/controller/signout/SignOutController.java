package com.xworkz.assignment.controller.signout;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.assignment.constants.EnumViews;
import com.xworkz.assignment.constants.ExceptionConstant;
import com.xworkz.assignment.constants.ViewMessageConstant;
import com.xworkz.assignment.exception.ControllerException;

@Controller
@RequestMapping("/")
public class SignOutController {

	private static Logger logger = LoggerFactory.getLogger(SignOutController.class);

	public SignOutController() {
		logger.info("created " + this.getClass().getSimpleName());
	}

	@RequestMapping("/logOut")
	public ModelAndView logOut(HttpServletRequest request) throws ControllerException {

		try {
			HttpSession session = request.getSession(false);
			if (session.getAttribute(ViewMessageConstant.SESSION_USER) != null) {
				session.invalidate();
				return new ModelAndView(EnumViews.SignIn.toString());
			}
		} catch (Exception e) {
			logger.error(
					ExceptionConstant.EXCEPTION_FROM_CONTROLLER + this.getClass().getSimpleName() + e.getMessage());
			throw new ControllerException(
					ExceptionConstant.EXCEPTION_FROM_CONTROLLER + this.getClass().getSimpleName() + e.getMessage());
		}
		return new ModelAndView(EnumViews.SignIn.toString());
	}

}
