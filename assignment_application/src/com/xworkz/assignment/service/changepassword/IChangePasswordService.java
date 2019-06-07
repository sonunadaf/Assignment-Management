package com.xworkz.assignment.service.changepassword;

import com.xworkz.assignment.dto.changepassword.ChangePasswordDTO;
import com.xworkz.assignment.exception.DAOException;

public interface IChangePasswordService {

	public boolean changePassword(ChangePasswordDTO changePasswordDTO) throws DAOException;

}
