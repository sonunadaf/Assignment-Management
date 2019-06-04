package com.xworkz.assignment.dao.signup;

import com.xworkz.assignment.entity.admin.AdminEntity;
import com.xworkz.assignment.exception.DAOException;

public interface ISignUpDAO {

	public Integer save(AdminEntity adminEntity) throws DAOException;

}
