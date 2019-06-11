package com.xworkz.assignment.dao.signin;

import org.springframework.stereotype.Repository;

import com.xworkz.assignment.entity.admin.AdminEntity;
import com.xworkz.assignment.exception.DAOException;

@Repository
public interface ISignInDAO {
	public void updateFailSignIn(AdminEntity adminEntity) throws DAOException;

	public void updateFailLoginByZero(AdminEntity getAdminFromDb) throws DAOException;
}
