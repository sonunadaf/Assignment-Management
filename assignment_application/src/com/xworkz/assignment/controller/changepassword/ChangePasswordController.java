package com.xworkz.assignment.controller.changepassword;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.assignment.constants.EnumUtil;
import com.xworkz.assignment.dto.changepassword.ChangePasswordDTO;
import com.xworkz.assignment.exception.DAOException;
import com.xworkz.assignment.service.changepassword.IChangePasswordService;

@Controller
@RequestMapping("/")
public class ChangePasswordController {

	@Autowired
	private IChangePasswordService changePasswordService;

	@RequestMapping(value = "/changePassword", method = RequestMethod.GET)
	public ModelAndView changePassword(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			return new ModelAndView(EnumUtil.ChangePassword.toString());
		} else {
			return new ModelAndView(EnumUtil.SignIn.toString());
		}
	}

	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public ModelAndView changePassword(ChangePasswordDTO changePasswordDTO, HttpServletRequest request) {
		System.out.println("change password " + changePasswordDTO);
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.getAttribute("admin");
			try {
				boolean result = changePasswordService.changePassword(changePasswordDTO);
				if (result) {
					return new ModelAndView(EnumUtil.CreateAssignment.toString(), "message",
							"password change succesfull");
				} else {
					return new ModelAndView(EnumUtil.ChangePassword.toString(), "updatemsg", "incorrect old password");
				}
			} catch (DAOException e) {
				e.printStackTrace();
			}
		}
		return new ModelAndView(EnumUtil.SignIn.toString());
	}
}
