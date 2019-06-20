package com.xworkz.assignment.service.getsolvedassignment;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.assignment.constants.ExceptionConstant;
import com.xworkz.assignment.dao.getsolvedassignment.GetSolvedAssignmentByPinDAO;
import com.xworkz.assignment.exception.DAOException;
import com.xworkz.assignment.exception.ServiceException;

@Service
public class GetSolvedAssignmentByPinServiceImpl implements GetSolvedAssignmentByPinService {

	@Autowired
	private GetSolvedAssignmentByPinDAO getSolvedAssignmentDao;
	private static Logger logger = LoggerFactory.getLogger(GetSolvedAssignmentByPinServiceImpl.class);

	@Override
	public List<?> getSolvedAssignmentbyPin(String email) throws ServiceException {

		List list = null;
		try {
			list = getSolvedAssignmentDao.getSolvedAssignmentbyPin(email);
		} catch (DAOException e) {
			logger.error(ExceptionConstant.EXCEPTION_FROM_SERVICE + this.getClass().getSimpleName() + e.getMessage());
			throw new ServiceException(
					ExceptionConstant.EXCEPTION_FROM_SERVICE + this.getClass().getSimpleName() + e.getMessage());
		}

		return list;
	}

}
