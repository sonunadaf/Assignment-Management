package com.xworkz.assignment.dao.changepassword;

import com.xworkz.assignment.entity.admin.AdminEntity;
import com.xworkz.assignment.exception.DAOException;

public interface IChangePasswordDAO {

	public boolean changePassword(AdminEntity adminEntity) throws DAOException;

}
