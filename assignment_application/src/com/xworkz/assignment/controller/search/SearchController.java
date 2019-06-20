package com.xworkz.assignment.controller.search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.assignment.constants.EnumViews;
import com.xworkz.assignment.constants.ViewMessageConstant;
import com.xworkz.assignment.entity.admin.AdminEntity;
import com.xworkz.assignment.exception.ControllerException;

@Controller
@RequestMapping("/")
public class SearchController {

	@RequestMapping(value = "/serarchData", method = RequestMethod.GET)
	public ModelAndView search(HttpServletRequest request) throws ControllerException {
		try {
			HttpSession session = request.getSession(false);
			if (session.getAttribute(ViewMessageConstant.SESSION_USER) != null) { 
				AdminEntity admin = (AdminEntity) session.getAttribute(ViewMessageConstant.SESSION_USER);
				return new ModelAndView(EnumViews.Search.toString()).addObject(ViewMessageConstant.SESSION_USER, admin);
			}
		} catch (Exception e) {
			throw new ControllerException(e.getMessage());
		}

		return new ModelAndView(EnumViews.SignIn.toString());
	}

}
