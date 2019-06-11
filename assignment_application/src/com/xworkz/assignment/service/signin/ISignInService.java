package com.xworkz.assignment.service.signin;

import com.xworkz.assignment.dto.signin.SignInDTO;
import com.xworkz.assignment.entity.admin.AdminEntity;
import com.xworkz.assignment.exception.DAOException;
import com.xworkz.assignment.exception.ServiceException;

public interface ISignInService {

	public AdminEntity signIn(SignInDTO signInDTO) throws ServiceException;

	public void updateFailLoginByZero(AdminEntity getAdminFromDb) throws DAOException;

	public void updateFailLogin(AdminEntity getAdminFromDb) throws DAOException;
}
