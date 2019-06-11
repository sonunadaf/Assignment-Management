package com.xworkz.assignment.controller.signout;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.assignment.constants.EnumUtil;
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
		HttpSession session = request.getSession(false);
		try {
			if (session != null) {
				session.invalidate();
				if (session != null)
					System.err.println("session after logout : " + session);
				return new ModelAndView(EnumUtil.SignIn.toString());
			}
		} catch (Exception e) {
			throw new ControllerException(e.getMessage());
		}
		return new ModelAndView(EnumUtil.SignIn.toString());
	}

}
