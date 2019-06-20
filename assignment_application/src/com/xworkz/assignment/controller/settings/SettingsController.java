package com.xworkz.assignment.controller.settings;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.assignment.constants.EnumViews;
import com.xworkz.assignment.constants.ExceptionConstant;
import com.xworkz.assignment.constants.ViewMessageConstant;
import com.xworkz.assignment.dto.settings.SettingsDTO;
import com.xworkz.assignment.entity.admin.AdminEntity;
import com.xworkz.assignment.exception.ControllerException;
import com.xworkz.assignment.exception.ServiceException;
import com.xworkz.assignment.service.settings.ISettingsService;
import com.xworkz.assignment.service.settings.SettingsServiceImpl;

@Controller
@RequestMapping("/")
public class SettingsController {

	@Autowired
	private ISettingsService settingsService;

	private static Logger logger = LoggerFactory.getLogger(SettingsServiceImpl.class); 

	@RequestMapping(value = "/adminSettings", method = RequestMethod.GET)
	public ModelAndView updateSettings(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute(ViewMessageConstant.SESSION_USER) != null) {
			AdminEntity admin = (AdminEntity) session.getAttribute(ViewMessageConstant.SESSION_USER);
			return new ModelAndView(EnumViews.Settings.toString()).addObject(ViewMessageConstant.SESSION_USER, admin);
		} else {
			return new ModelAndView(EnumViews.SignIn.toString());
		}
	}

	@RequestMapping(value = "/adminSettings", method = RequestMethod.POST)
	public ModelAndView updateSettings(SettingsDTO settingsDTO, HttpServletRequest request) throws ControllerException {
		HttpSession session = request.getSession();
		AdminEntity admin = null;
		try {
			if (session.getAttribute(ViewMessageConstant.SESSION_USER) != null) {
				admin = (AdminEntity) session.getAttribute(ViewMessageConstant.SESSION_USER);
				String ipAddress = request.getRemoteAddr();
				boolean status = settingsService.updateSettings(settingsDTO, ipAddress);
				if (status) {
					admin = settingsService.getAdminByEmail(settingsDTO.getEmail());
					session.removeAttribute(ViewMessageConstant.SESSION_USER);
					session.setAttribute(ViewMessageConstant.SESSION_USER, admin);
					return new ModelAndView(EnumViews.Settings.toString(), ViewMessageConstant.MESSAGE,
							ViewMessageConstant.UPDATE_SUCCESSFUL).addObject(ViewMessageConstant.SESSION_USER, admin);
				} else {
					return new ModelAndView(EnumViews.Settings.toString(), ViewMessageConstant.MESSAGE,
							ViewMessageConstant.UPDATE_UNSUCCESSFUL).addObject(ViewMessageConstant.SESSION_USER, admin);
				}

			} else {
				return new ModelAndView(EnumViews.SignIn.toString());
			}
		} catch (ServiceException e) {
			logger.error(
					ExceptionConstant.EXCEPTION_FROM_CONTROLLER + this.getClass().getSimpleName() + e.getMessage());
			throw new ControllerException(
					ExceptionConstant.EXCEPTION_FROM_CONTROLLER + this.getClass().getSimpleName() + e.getMessage());
		} catch (Exception e) {
			logger.error(
					ExceptionConstant.EXCEPTION_FROM_CONTROLLER + this.getClass().getSimpleName() + e.getMessage());
			throw new ControllerException(
					ExceptionConstant.EXCEPTION_FROM_CONTROLLER + this.getClass().getSimpleName() + e.getMessage());
		}
	}
}
