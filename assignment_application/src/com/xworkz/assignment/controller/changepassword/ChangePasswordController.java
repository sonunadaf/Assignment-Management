package com.xworkz.assignment.controller.changepassword;

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
import com.xworkz.assignment.dto.changepassword.ChangePasswordDTO;
import com.xworkz.assignment.entity.admin.AdminEntity;
import com.xworkz.assignment.exception.ControllerException;
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
			return new ModelAndView(EnumViews.ChangePassword.toString());
		} else {
			return new ModelAndView(EnumViews.SignIn.toString());
		}
	}

	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public ModelAndView changePassword(ChangePasswordDTO changePasswordDTO, HttpServletRequest request)
			throws ControllerException {
		HttpSession session = request.getSession(false);
		try {
			if (session.getAttribute(ViewMessageConstant.SESSION_USER) != null) {
				AdminEntity admin = (AdminEntity) session.getAttribute(ViewMessageConstant.SESSION_USER);
				boolean result = changePasswordService.changePassword(changePasswordDTO);
				if (result) {
					return new ModelAndView(EnumViews.CreateAssignment.toString(), ViewMessageConstant.MESSAGE,
							ViewMessageConstant.PASSWORD_CHANGE_SUCCESS).addObject(ViewMessageConstant.SESSION_USER,
									admin);
				} else {
					return new ModelAndView(EnumViews.ChangePassword.toString(), ViewMessageConstant.UPDATE_MESSAGE,
							ViewMessageConstant.INCORRECT_OLD_PASSWORD).addObject(ViewMessageConstant.SESSION_USER,
									admin);
				}

			} else {
				return new ModelAndView(EnumViews.SignIn.toString());
			}
		} catch (Exception e) {
			throw new ControllerException(
					ExceptionConstant.EXCEPTION_FROM_CONTROLLER + this.getClass().getSimpleName() + e.getMessage());
		}
	}
}
