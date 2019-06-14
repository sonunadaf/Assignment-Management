package com.xworkz.assignment.service.signin;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.xworkz.assignment.dao.getadminentitybyemail.IGetAdminEntityByEmailDAO;
import com.xworkz.assignment.dao.signin.ISignInDAO;
import com.xworkz.assignment.dto.signin.SignInDTO;
import com.xworkz.assignment.entity.admin.AdminEntity;
import com.xworkz.assignment.exception.DAOException;
import com.xworkz.assignment.exception.ServiceException;

@Service
public class SignInServiceImpl implements ISignInService {

	@Autowired
	private IGetAdminEntityByEmailDAO adminDAO;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private ISignInDAO signInDAO;

	public SignInServiceImpl() {
		System.out.println("created : " + this.getClass().getSimpleName());
	}

	@Override
	public AdminEntity signIn(SignInDTO signInDTO) throws ServiceException {

		String userid = signInDTO.getUser();
		String password = signInDTO.getPassword();
		System.out.println("SignIn method invoked from " + this.getClass().getSimpleName());
		System.out.println(userid + " " + password);
		AdminEntity getAdminFromDb = null;

		try {
			if (userid != null && password != null) {
				getAdminFromDb = adminDAO.getEntityByEmail(userid);

				if (getAdminFromDb != null) {

					boolean matched = passwordEncoder.matches(password, getAdminFromDb.getPassword());
					System.out.println("password matching : " + matched);
					if (matched) {
						getAdminFromDb.setPassword(password);
						System.out.println("Sign In From service invoked " + getAdminFromDb.getPassword());
					}
				}
			}
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return getAdminFromDb;
	}

	@Override
	public void updateFailLogin(AdminEntity getAdminFromDb) throws ServiceException {
		AdminEntity adminEntity = null;
		try {
			adminEntity = adminDAO.getEntityByEmail(getAdminFromDb.getEmailId());
			signInDAO.updateFailSignIn(adminEntity);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public void updateFailLoginByZero(AdminEntity getAdminFromDb) throws ServiceException {
		AdminEntity adminEntity = null;
		try {
			adminEntity = adminDAO.getEntityByEmail(getAdminFromDb.getEmailId());

			if (adminEntity != null) {
				adminEntity.setFailLogin(0);
				adminEntity.setLastLogin(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
			}
			signInDAO.updateFailLoginByZero(adminEntity);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

}
