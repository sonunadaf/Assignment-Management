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
import com.xworkz.assignment.constants.EnumUtil;
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
		if (session != null) {

			AdminEntity admin = (AdminEntity) session.getAttribute("admin");
			return new ModelAndView(EnumUtil.Settings.toString()).addObject("admin", admin);
		} else {
			return new ModelAndView(EnumUtil.SignIn.toString());
		}
	}

	@RequestMapping(value = "/adminSettings", method = RequestMethod.POST)
	public ModelAndView updateSettings(SettingsDTO settingsDTO, HttpServletRequest request) throws ControllerException {
		HttpSession session = request.getSession();
		try {
			if (session != null) {

				AdminEntity admin = (AdminEntity) session.getAttribute("admin");
				String ipAddress = request.getRemoteAddr();
				boolean status = settingsService.updateSettings(settingsDTO,ipAddress);
				if (status) {
					return new ModelAndView(EnumUtil.SignIn.toString(), "message", "Updated Successful")
							.addObject("admin", admin);
				} else {
					return new ModelAndView(EnumUtil.Settings.toString(), "message", "Updates unsuccessful")
							.addObject("admin", admin);
				}

			} else {
				return new ModelAndView(EnumUtil.SignIn.toString());
			}
		} catch (ServiceException e) {
			logger.error("exception from Settings Controller : " + e.getMessage());
			throw new ControllerException(e.getMessage());
		} catch (Exception e) {
			logger.error("exception from Settings Controller : " + e.getMessage());
			throw new ControllerException(e.getMessage());
		}
	}
}
