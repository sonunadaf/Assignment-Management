package com.xworkz.assignment.controller.signout;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.assignment.constants.EnumUtil;
import com.xworkz.assignment.entity.admin.AdminEntity;

@Controller
@RequestMapping("/")
public class SignOutController {

	private static Logger logger = LoggerFactory.getLogger(SignOutController.class);

	public SignOutController() {
		logger.info("created " + this.getClass().getSimpleName());
	}

	@RequestMapping("/logOut")
	public ModelAndView logOut(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			AdminEntity adminEntity = (AdminEntity) session.getAttribute("admin");
			// logger.error("invoked logOut method from " +
			// this.getClass().getSimpleName());
			System.err.println("session before logout : " + session);
			// session.removeAttribute("admin");
			session.invalidate();
			if(session!=null)
				System.err.println("session after logout : " + session);
			return new ModelAndView(EnumUtil.SignIn.toString());
		}
		return new ModelAndView(EnumUtil.SignIn.toString());
	}

}
