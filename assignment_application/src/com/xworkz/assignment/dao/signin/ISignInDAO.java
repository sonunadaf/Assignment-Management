package com.xworkz.assignment.dao.signin;

import org.springframework.stereotype.Repository;

import com.xworkz.assignment.entity.admin.AdminEntity;

@Repository
public interface ISignInDAO {
	public void updateFailSignIn(AdminEntity adminEntity);

	public void updateFailLoginByZero(AdminEntity getAdminFromDb);
}
