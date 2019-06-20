package com.xworkz.assignment.dao.getsolvedassignment;

import java.util.List;

import com.xworkz.assignment.exception.DAOException;

public interface GetSolvedAssignmentByPinDAO {
	
	public List<?> getSolvedAssignmentbyPin(String email) throws DAOException;

}
