package com.xworkz.assignment.service.assign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.assignment.constants.ExceptionConstant;
import com.xworkz.assignment.dao.getcreateassignmentbypin.GetCreateAssignmentByPinDAO;
import com.xworkz.assignment.entity.admin.AdminEntity;
import com.xworkz.assignment.entity.createassignment.CreateAssignmentEntity;
import com.xworkz.assignment.exception.DAOException;
import com.xworkz.assignment.exception.ServiceException;
import com.xworkz.assignment.mailsender.assign.AssignToStudent;

@Service
public class AssignServiceImpl implements AssignService {

	@Autowired
	private GetCreateAssignmentByPinDAO getCreateAssignment;

	@Autowired
	private AssignToStudent assignToStudent;
	private static Logger logger = LoggerFactory.getLogger(AssignServiceImpl.class);

	@Override
	public boolean assignService(Integer pin, String assign, AdminEntity admin) throws ServiceException {
		try {
			if (assign != null) {
				String[] assignList = assign.split(",");
				CreateAssignmentEntity createAssignmentFromdb = getCreateAssignment.getCreateAssignmentEntity(pin);
				if (createAssignmentFromdb != null) {
					assignToStudent.sendMail(assignList, createAssignmentFromdb);
				} else {
					return false;
				}
			}
		} catch (DAOException e) {
			logger.error(ExceptionConstant.EXCEPTION_FROM_SERVICE + this.getClass().getSimpleName() + e.getMessage());
			throw new ServiceException(
					ExceptionConstant.EXCEPTION_FROM_SERVICE + this.getClass().getSimpleName() + e.getMessage());
		} catch (Exception e) {
			logger.error(ExceptionConstant.EXCEPTION_FROM_SERVICE + this.getClass().getSimpleName() + e.getMessage());
			throw new ServiceException(
					ExceptionConstant.EXCEPTION_FROM_SERVICE + this.getClass().getSimpleName() + e.getMessage());
		}
		return true;
	}

}
