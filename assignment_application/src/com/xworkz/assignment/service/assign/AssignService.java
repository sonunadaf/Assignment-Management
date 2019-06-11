package com.xworkz.assignment.service.assign;

import com.xworkz.assignment.entity.admin.AdminEntity;
import com.xworkz.assignment.exception.ServiceException;

public interface AssignService {
	public boolean assignService(Integer pin, String assign, AdminEntity admin) throws ServiceException;

}
