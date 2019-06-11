package com.xworkz.assignment.restservice.searchall;

import java.util.List;

import com.xworkz.assignment.entity.createassignment.CreateAssignmentEntity;
import com.xworkz.assignment.exception.ServiceException;

public interface ISearchAllServiceRestController {

	public List<CreateAssignmentEntity> getAllAssignmentEntities(String email) throws ServiceException;

}
