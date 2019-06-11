package com.xworkz.assignment.controller.assign;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.assignment.constants.EnumUtil;
import com.xworkz.assignment.entity.admin.AdminEntity;
import com.xworkz.assignment.exception.ControllerException;
import com.xworkz.assignment.exception.ServiceException;
import com.xworkz.assignment.service.assign.AssignService;

@Controller
@RequestMapping("/")
public class AssignController {

	@Autowired
	private AssignService assignService;
	private static Logger logger = LoggerFactory.getLogger(AssignController.class);

	@RequestMapping(value = "/assignToAll", method = RequestMethod.GET)
	public ModelAndView onAssign(HttpServletRequest request) {
		HttpSession session = request.getSession(false);

		if (session != null) {
			return new ModelAndView(EnumUtil.Assign.toString());
		}
		return new ModelAndView(EnumUtil.SignIn.toString());

	}

	@RequestMapping(value = "/assignToAll", method = RequestMethod.POST)
	public ModelAndView onAssign(@RequestParam Integer pin, @RequestParam String assign, HttpServletRequest request)
			throws ControllerException {
		logger.info("Pin number " + pin);
		logger.info("asssign number " + pin);
		try {
			HttpSession session = request.getSession(false);

			if (session != null) {
				AdminEntity admin = (AdminEntity) session.getAttribute("admin");
				boolean status = assignService.assignService(pin, assign, admin);
				if (status) {
					return new ModelAndView(EnumUtil.Assign.toString(), "msg", "Assign successful");
				} else {
					return new ModelAndView(EnumUtil.Assign.toString(), "err", "Assignment Pin is incorrect");
				}

			}
		} catch (ServiceException e) {
			logger.error("exception from controller " + e.getMessage());
			throw new ControllerException(e.getMessage());
		}

		return new ModelAndView(EnumUtil.SignIn.toString());
	}
}
