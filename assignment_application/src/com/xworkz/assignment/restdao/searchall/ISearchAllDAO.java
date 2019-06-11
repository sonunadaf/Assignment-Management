package com.xworkz.assignment.restdao.searchall;

import java.util.List;

import com.xworkz.assignment.entity.createassignment.CreateAssignmentEntity;
import com.xworkz.assignment.exception.DAOException;

public interface ISearchAllDAO {

	public List<CreateAssignmentEntity> getAllAssignmentEntities(String email) throws DAOException;

}
