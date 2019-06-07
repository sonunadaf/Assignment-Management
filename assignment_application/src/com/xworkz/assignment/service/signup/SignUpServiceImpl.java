package com.xworkz.assignment.service.signup;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.xworkz.assignment.dao.getadminentitybyemail.IGetAdminEntityByEmailDAO;
import com.xworkz.assignment.dao.signup.ISignUpDAO;
import com.xworkz.assignment.dto.signup.SignUpDTO;
import com.xworkz.assignment.entity.admin.AdminEntity;
import com.xworkz.assignment.exception.DAOException;
import com.xworkz.assignment.exception.ServiceException;
import com.xworkz.assignment.mailsender.MailSenderToUser;

@Service
public class SignUpServiceImpl implements ISignUpService {

	@Autowired
	private ISignUpDAO iSignUpDAO;
	@Autowired
	private IGetAdminEntityByEmailDAO getIdByEmail;

	@Autowired
	private MailSenderToUser mailSender;

	@Autowired
	private IGetAdminEntityByEmailDAO getEntityByEmail;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public SignUpServiceImpl() {
		System.out.println("created : " + this.getClass().getSimpleName());
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
			String password = "12345";
			if (isValid) {
				AdminEntity adminEntity = new AdminEntity();
				BeanUtils.copyProperties(signupDto, adminEntity);
				adminEntity.setContactNumber(signupDto.getCountryCode() + signupDto.getPhoneNo());
				adminEntity.setFirstLogin(true);
				adminEntity.setPassword(passwordEncoder.encode(password));
				adminEntity.setDate(new Date() + "");
				adminEntity.setFailLogin(0);
				System.out.println(adminEntity);
				Integer id = iSignUpDAO.save(adminEntity);
				if (id != null && id > 0) {
					mailSender.sendMail(email, password);
				}
			}
		} catch (DAOException e) {
			System.err.println("Exception from Service" + e.getMessage());
			throw new ServiceException("Exception from Service " + e.getMessage());
		}
		return "Sign Up Succesful";
	}

	@Override
	public AdminEntity getAdminEntityByEmail(String email) {
		AdminEntity adminEntity = null;

		if (email != null) {
			try {
				adminEntity = getEntityByEmail.getEntityByEmail(email);
			} catch (DAOException e) {
				e.printStackTrace();
			}
		}
		return adminEntity;
	}

}
