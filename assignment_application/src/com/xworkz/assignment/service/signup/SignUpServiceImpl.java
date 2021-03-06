package com.xworkz.assignment.service.signup;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.xworkz.assignment.constants.ExceptionConstant;
import com.xworkz.assignment.constants.ViewMessageConstant;
import com.xworkz.assignment.dao.getadminentitybyemail.IGetAdminEntityByEmailDAO;
import com.xworkz.assignment.dao.member.GetMemberByEmail;
import com.xworkz.assignment.dao.signup.ISignUpDAO;
import com.xworkz.assignment.dto.signup.SignUpDTO;
import com.xworkz.assignment.entity.admin.AdminEntity;
import com.xworkz.assignment.entity.member.MemberEntity;
import com.xworkz.assignment.exception.DAOException;
import com.xworkz.assignment.exception.ServiceException;
import com.xworkz.assignment.mailsender.MailSenderToUser;
import com.xworkz.assignment.passwordgenerator.UserPasswordGenerator;

@Service
public class SignUpServiceImpl implements ISignUpService {

	@Autowired
	private ISignUpDAO iSignUpDAO;
	@Autowired
	private IGetAdminEntityByEmailDAO getIdByEmail;

	@Autowired
	private MailSenderToUser mailSender;
	@Autowired
	private UserPasswordGenerator gerenatePassword;

	@Autowired
	private IGetAdminEntityByEmailDAO getEntityByEmail;

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private GetMemberByEmail getMemberByEmail;

	private static Logger logger = LoggerFactory.getLogger(SignUpServiceImpl.class);

	public SignUpServiceImpl() {
		logger.info("created : " + this.getClass().getSimpleName());
	}

	@Override
	public String signUp(SignUpDTO signupDto) throws ServiceException {
		try {
			boolean isValid = true;
			String firstName = signupDto.getFirstName();
			String email = signupDto.getEmailId();
			String mobile = signupDto.getPhoneNo();
			AdminEntity admin = getIdByEmail.getEntityByEmail(email);
			if (firstName.length() < 4) {
				isValid = false;
			} else if (admin != null) {
				isValid = false;
			} else if (mobile.length() != 10) {
				isValid = false;
			}
			String password = gerenatePassword.generatePassayPassword();
			if (isValid) {
				AdminEntity adminEntity = new AdminEntity();
				BeanUtils.copyProperties(signupDto, adminEntity);
				adminEntity.setContactNumber(signupDto.getCountryCode() + signupDto.getPhoneNo());
				adminEntity.setFirstLogin(true);
				adminEntity.setPassword(passwordEncoder.encode(password));
				adminEntity.setDate(new Date() + "");
				adminEntity.setFailLogin(0);
				adminEntity.setLastLogin(new SimpleDateFormat("YYYY-MM-DD HH:MM:SS").format(new Date()));
				System.out.println(adminEntity);
				Integer id = iSignUpDAO.save(adminEntity);
				if (id != null && id > 0) {
					mailSender.sendMail(email, password);
				}
			}
		} catch (DAOException e) {
			throw new ServiceException(
					ExceptionConstant.EXCEPTION_FROM_SERVICE + this.getClass().getSimpleName() + e.getMessage());
		}
		return ViewMessageConstant.SIGNUP_SUCCESS;
	}

	@Override
	public AdminEntity getAdminEntityByEmail(String email) throws ServiceException {
		AdminEntity adminEntity = null;

		if (email != null) {
			try {
				adminEntity = getEntityByEmail.getEntityByEmail(email);
			} catch (DAOException e) {
				logger.error(
						ExceptionConstant.EXCEPTION_FROM_SERVICE + this.getClass().getSimpleName() + e.getMessage());
				throw new ServiceException(
						ExceptionConstant.EXCEPTION_FROM_SERVICE + this.getClass().getSimpleName() + e.getMessage());
			}
		}
		return adminEntity;
	}

	@Override
	public MemberEntity getMemberEntity(String email) throws ServiceException {
		MemberEntity memberEntity = null;
		if (email != null) {

			try {
				memberEntity = getMemberByEmail.getMemberEntity(email);
			} catch (DAOException e) {
				logger.error(
						ExceptionConstant.EXCEPTION_FROM_SERVICE + this.getClass().getSimpleName() + e.getMessage());
				throw new ServiceException(
						ExceptionConstant.EXCEPTION_FROM_SERVICE + this.getClass().getSimpleName() + e.getMessage());
			}
		}
		return memberEntity;
	}

}
