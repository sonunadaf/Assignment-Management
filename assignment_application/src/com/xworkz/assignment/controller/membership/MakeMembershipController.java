package com.xworkz.assignment.controller.membership;

import java.util.List;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xworkz.assignment.constants.EnumViews;
import com.xworkz.assignment.constants.ExceptionConstant;
import com.xworkz.assignment.constants.ViewMessageConstant;
import com.xworkz.assignment.dao.member.GetMemberByEmail;
import com.xworkz.assignment.dto.signin.SignInDTO;
import com.xworkz.assignment.entity.admin.AdminEntity;
import com.xworkz.assignment.entity.member.MemberEntity;
import com.xworkz.assignment.exception.ControllerException;
import com.xworkz.assignment.exception.DAOException;
import com.xworkz.assignment.exception.ServiceException;
import com.xworkz.assignment.mailsender.membership.MembershipConfirmationSendMail;
import com.xworkz.assignment.service.signin.ISignInService;

@Controller
@RequestMapping("/")
public class MakeMembershipController {

	@Autowired
	private ISignInService iSignInService;
	@Autowired
	private GetMemberByEmail addMember;
	@Autowired
	private MembershipConfirmationSendMail confirmationSendMail;
	private static Logger logger = LoggerFactory.getLogger(MakeMembershipController.class);

	@RequestMapping(value = "/memLogin", method = RequestMethod.POST)
	public ModelAndView makeSignIn(SignInDTO signInDTO, HttpServletRequest request) throws ControllerException {

		try {
			AdminEntity adminEntityFromDb = iSignInService.signIn(signInDTO);
			if (adminEntityFromDb.getPassword().equals(signInDTO.getPassword()) && adminEntityFromDb.isOwner()) {
				HttpSession session = request.getSession(true);
				session.setAttribute(ViewMessageConstant.MAKE_MEMBER_USER, adminEntityFromDb);
				List<MemberEntity> listOfMemberFromDb = addMember.getListOfMemberEntity();
				ObjectMapper objectMapper = new ObjectMapper();
				String jsonListOfMember = objectMapper.writeValueAsString(listOfMemberFromDb);
				return new ModelAndView(EnumViews.AddMember.toString()).addObject("jsonListOfMember", jsonListOfMember);

			} else {
				return new ModelAndView(EnumViews.MemSignin.toString(), ViewMessageConstant.MESSAGE,
						ViewMessageConstant.INCORRECT_ANY);
			}
		} catch (ServiceException e) {
			logger.error(ExceptionConstant.EXCEPTION_FROM_CONTROLLER + this.getClass().getSimpleName() + " "
					+ e.getMessage());
			throw new ControllerException(ExceptionConstant.EXCEPTION_FROM_CONTROLLER + this.getClass().getSimpleName()
					+ " " + e.getMessage());
		} catch (DAOException e) {
			logger.error(ExceptionConstant.EXCEPTION_FROM_CONTROLLER + this.getClass().getSimpleName() + " "
					+ e.getMessage());
			throw new ControllerException(
					ExceptionConstant.EXCEPTION_FROM_CONTROLLER + this.getClass().getSimpleName());

		} catch (JsonProcessingException e) {
			logger.error(ExceptionConstant.EXCEPTION_FROM_CONTROLLER + this.getClass().getSimpleName() + " "
					+ e.getMessage());
			throw new ControllerException(
					ExceptionConstant.EXCEPTION_FROM_CONTROLLER + this.getClass().getSimpleName());
		}
	}

	@RequestMapping("/addMember")
	public ModelAndView makeSignIn(@RequestParam String newMember, HttpServletRequest request)
			throws ControllerException {

		HttpSession session = request.getSession();
		AdminEntity adminFromDB = (AdminEntity) session.getAttribute(ViewMessageConstant.MAKE_MEMBER_USER);
		if (adminFromDB != null) {
			try {
				MemberEntity memberEntity = addMember.getMemberEntity(newMember);
				if (memberEntity == null) {
					boolean status = addMember.addMember(newMember);
					if (status) {
						confirmationSendMail.sendMail(newMember, adminFromDB.getEmailId());
						List<MemberEntity> listOfMemberFromDb = addMember.getListOfMemberEntity();
						ObjectMapper objectMapper = new ObjectMapper();
						String jsonListOfMember = objectMapper.writeValueAsString(listOfMemberFromDb);
						return new ModelAndView(EnumViews.AddMember.toString(), ViewMessageConstant.MSG,
								ViewMessageConstant.MEMBER_ADDED_SUCCESS).addObject("jsonListOfMember",
										jsonListOfMember);
					} else {

						return new ModelAndView(EnumViews.AddMember.toString());
					}
				} else {
					return new ModelAndView(EnumViews.AddMember.toString(), ViewMessageConstant.ERR,
							ViewMessageConstant.MEMBER_EXIST);
				}
			} catch (DAOException e) {
				logger.error(ExceptionConstant.EXCEPTION_FROM_CONTROLLER + this.getClass().getSimpleName() + " "
						+ e.getMessage());
				throw new ControllerException(ExceptionConstant.EXCEPTION_FROM_CONTROLLER
						+ this.getClass().getSimpleName() + " " + e.getMessage());
			} catch (JsonProcessingException e) {
				logger.error(ExceptionConstant.EXCEPTION_FROM_CONTROLLER + this.getClass().getSimpleName() + " "
						+ e.getMessage());
				throw new ControllerException(ExceptionConstant.EXCEPTION_FROM_CONTROLLER
						+ this.getClass().getSimpleName() + " " + e.getMessage());
			} catch (ServiceException e) {
				logger.error(ExceptionConstant.EXCEPTION_FROM_CONTROLLER + this.getClass().getSimpleName() + " "
						+ e.getMessage());
				throw new ControllerException(ExceptionConstant.EXCEPTION_FROM_CONTROLLER
						+ this.getClass().getSimpleName() + " " + e.getMessage());
			}

		} else {
			return new ModelAndView(EnumViews.MemSignin.toString());
		}
	}
}
