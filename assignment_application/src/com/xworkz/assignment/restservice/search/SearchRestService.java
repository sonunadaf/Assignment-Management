package com.xworkz.assignment.restservice.search;

import com.xworkz.assignment.entity.createassignment.CreateAssignmentEntity;
import com.xworkz.assignment.exception.ServiceException;

public interface SearchRestService {

	public CreateAssignmentEntity getCreatedAssignment(String email, Integer pin) throws ServiceException;

}
