package com.xworkz.assignment.service.signup;

import com.xworkz.assignment.dto.signup.SignUpDTO;
import com.xworkz.assignment.entity.admin.AdminEntity;
import com.xworkz.assignment.entity.member.MemberEntity;
import com.xworkz.assignment.exception.ServiceException;

public interface ISignUpService {

	public String signUp(SignUpDTO signupDto) throws ServiceException;

	public AdminEntity getAdminEntityByEmail(String email) throws ServiceException;
	
	public MemberEntity getMemberEntity(String email) throws ServiceException;

}
