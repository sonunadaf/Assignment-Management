package com.xworkz.assignment.service.signin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.xworkz.assignment.dao.getadminentitybyemail.IGetAdminEntityByEmailDAO;
import com.xworkz.assignment.dto.signin.SignInDTO;
import com.xworkz.assignment.entity.admin.AdminEntity;
import com.xworkz.assignment.exception.DAOException;

@Service
public class SignInServiceImpl implements ISignInService {

	@Autowired
	private IGetAdminEntityByEmailDAO adminDAO;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public SignInServiceImpl() {
		System.out.println("created : " + this.getClass().getSimpleName());
	}

	@Override
	public boolean signIn(SignInDTO signInDTO) {

		String userid = signInDTO.getUser();
		String password = signInDTO.getPassword();
		System.out.println("SignIn method invoked from " + this.getClass().getSimpleName());
		System.out.println(userid + " " + password);

		try {
			if (userid != null && password != null) {
				AdminEntity adminEntity = adminDAO.getEntityByEmail(userid);
				System.out.println(adminEntity.getPassword());
				boolean matched = passwordEncoder.matches(password, adminEntity.getPassword());
				if (userid.equals(adminEntity.getEmailId()) && matched) {
					System.out.println(adminEntity.getPassword());
					return true;
				}
			}

		} catch (DAOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
