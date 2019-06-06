package com.xworkz.assignment.service.signin;

import com.xworkz.assignment.dto.signin.SignInDTO;
import com.xworkz.assignment.entity.admin.AdminEntity;

public interface ISignInService {

	public AdminEntity signIn(SignInDTO signInDTO);

	public void updateFailLoginByZero(AdminEntity getAdminFromDb);

	public void updateFailLogin(AdminEntity getAdminFromDb);
}
