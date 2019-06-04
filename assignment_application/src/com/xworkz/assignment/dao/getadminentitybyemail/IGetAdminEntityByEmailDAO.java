package com.xworkz.assignment.dao.getadminentitybyemail;

import com.xworkz.assignment.entity.admin.AdminEntity;
import com.xworkz.assignment.exception.DAOException;

public interface IGetAdminEntityByEmailDAO {

	public AdminEntity getEntityByEmail(String emailid) throws DAOException;

}
