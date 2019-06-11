package com.xworkz.assignment.restservice.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.assignment.entity.createassignment.CreateAssignmentEntity;
import com.xworkz.assignment.exception.DAOException;
import com.xworkz.assignment.exception.ServiceException;
import com.xworkz.assignment.restdao.search.SearchRestDAO;

@Service
public class SearchRestServiceImpl implements SearchRestService {

	@Autowired
	private SearchRestDAO searchRestDao;

	@Override
	public CreateAssignmentEntity getCreatedAssignment(String email, Integer pin) throws ServiceException {

		try {
			CreateAssignmentEntity assignmentEntity = searchRestDao.getCreatedAssignment(email, pin);
			if (assignmentEntity != null) {

				return assignmentEntity;
			}
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}

		return null;
	}

}
