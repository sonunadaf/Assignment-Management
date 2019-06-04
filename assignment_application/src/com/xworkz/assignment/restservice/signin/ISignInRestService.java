package com.xworkz.assignment.restservice.signin;

import com.xworkz.assignment.dto.signin.SignInDTO;

public interface ISignInRestService {

	public SignInDTO getSignInDTO(String email);
}
