package com.xworkz.assignment.restservice.signin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.assignment.dao.getadminentitybyemail.IGetAdminEntityByEmailDAO;
import com.xworkz.assignment.dto.signin.SignInDTO;
import com.xworkz.assignment.entity.admin.AdminEntity;
import com.xworkz.assignment.exception.DAOException;

@Service
public class SignInRestServiceImpl implements ISignInRestService {

	@Autowired
	private IGetAdminEntityByEmailDAO getEntityByEmailDAO;

	@Override
	public SignInDTO getSignInDTO(String email) {

		AdminEntity adminEntity = null;
		SignInDTO signInDTO = null;

		if (email != null) {

			try {
				adminEntity = getEntityByEmailDAO.getEntityByEmail(email);
				signInDTO = new SignInDTO();
				if (adminEntity != null) {
					signInDTO.setUser(adminEntity.getEmailId());
					signInDTO.setPassword(adminEntity.getPassword());
				}
			} catch (DAOException e) {
				e.printStackTrace();
			}
		}
		return signInDTO;
	}
}
