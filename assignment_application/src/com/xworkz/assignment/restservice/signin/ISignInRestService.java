package com.xworkz.assignment.restservice.signin;

import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.xworkz.assignment.dto.signin.SignInDTO;

public interface ISignInRestService {

	public SignInDTO getSignInDTO(String email);
	//InternalResourceViewResolver
}
