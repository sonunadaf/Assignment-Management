package com.xworkz.assignment.restservice.searchall;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.assignment.entity.createassignment.CreateAssignmentEntity;
import com.xworkz.assignment.exception.DAOException;
import com.xworkz.assignment.exception.ServiceException;
import com.xworkz.assignment.restdao.searchall.ISearchAllDAO;

@Service
public class SearchAllCreatedRestServiceImpl implements ISearchAllServiceRestController {

	@Autowired
	private ISearchAllDAO searchAllDao;
	private static Logger logger = LoggerFactory.getLogger(SearchAllCreatedRestServiceImpl.class);

	public SearchAllCreatedRestServiceImpl() {
		logger.info("created : " + this.getClass().getSimpleName());
	}

	@Override
	public List<CreateAssignmentEntity> getAllAssignmentEntities(String email) throws ServiceException {
		List<CreateAssignmentEntity> assignmentList = null;

		try {
			assignmentList = searchAllDao.getAllAssignmentEntities(email);
		} catch (DAOException e) {
			logger.error("Exception from SearchAllCreatedRestServiceImpl " + e.getMessage());
			throw new ServiceException(e.getMessage());
		} catch (Exception e) {
			logger.error("Exception from SearchAllCreatedRestServiceImpl " + e.getMessage());
			throw new ServiceException(e.getMessage());
		}
		return assignmentList;
	}

}
