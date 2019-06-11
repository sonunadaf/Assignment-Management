package com.xworkz.assignment.restdao.search;

import com.xworkz.assignment.entity.createassignment.CreateAssignmentEntity;
import com.xworkz.assignment.exception.DAOException;

public interface SearchRestDAO {

	public CreateAssignmentEntity getCreatedAssignment(String email, Integer pin) throws DAOException;

}
