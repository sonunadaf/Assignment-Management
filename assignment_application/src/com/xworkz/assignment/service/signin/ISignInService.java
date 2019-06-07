package com.xworkz.assignment.service.signin;

import com.xworkz.assignment.dto.signin.SignInDTO;
import com.xworkz.assignment.entity.admin.AdminEntity;
import com.xworkz.assignment.exception.DAOException;

public interface ISignInService {

	public AdminEntity signIn(SignInDTO signInDTO);

	public void updateFailLoginByZero(AdminEntity getAdminFromDb) throws DAOException;

	public void updateFailLogin(AdminEntity getAdminFromDb) throws DAOException;
}
