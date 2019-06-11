package com.xworkz.assignment.dao.createassignment;

import com.xworkz.assignment.entity.createassignment.CreateAssignmentEntity;
import com.xworkz.assignment.exception.DAOException;

public interface ICreateAssignmentDAO {

	public Integer saveCreatedAssignment(CreateAssignmentEntity assignmentEntity) throws DAOException;
}
