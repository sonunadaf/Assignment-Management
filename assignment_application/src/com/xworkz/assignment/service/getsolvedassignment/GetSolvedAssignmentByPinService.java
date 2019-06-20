package com.xworkz.assignment.service.getsolvedassignment;

import java.util.List;

import com.xworkz.assignment.exception.ServiceException;

public interface GetSolvedAssignmentByPinService {
	public List<?> getSolvedAssignmentbyPin(String email) throws ServiceException;


}
