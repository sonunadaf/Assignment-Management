package com.xworkz.assignment.controller.search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.assignment.constants.EnumUtil;
import com.xworkz.assignment.entity.admin.AdminEntity;

@Controller
@RequestMapping("/")
public class SearchController {

	@RequestMapping(value = "/serarchData", method = RequestMethod.GET)
	public ModelAndView search(HttpServletRequest request) {
		try {
			HttpSession session = request.getSession(false);
			if (session != null) {
				AdminEntity admin = (AdminEntity) session.getAttribute("admin");
				return new ModelAndView(EnumUtil.Search.toString()).addObject("admin", admin);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView(EnumUtil.SignIn.toString());
	}

}
