package com.xworkz.assignment.service.createassignment;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.assignment.constants.ExceptionConstant;
import com.xworkz.assignment.dao.createassignment.ICreateAssignmentDAO;
import com.xworkz.assignment.dto.createassignment.CreateAssignmentDTO;
import com.xworkz.assignment.entity.createassignment.CreateAssignmentEntity;
import com.xworkz.assignment.exception.DAOException;
import com.xworkz.assignment.exception.ServiceException;
import com.xworkz.assignment.mailsender.createassignment.CreateAssignmentMailSend;

@Service
public class CreateAssignentServiceImpl implements ICreateAssignentService {

	@Autowired
	private ICreateAssignmentDAO assignmentDAO;
	@Autowired
	private CreateAssignmentMailSend createAssignmentMailSend;

	private static Logger logger = LoggerFactory.getLogger(CreateAssignentServiceImpl.class);

	public CreateAssignentServiceImpl() {

		logger.info("Create : " + this.getClass().getSimpleName());
	}

	@Override
	public String createAssignment(String email, CreateAssignmentDTO assignmentDTO) throws ServiceException {

		try {
			if (assignmentDTO != null) {
				CreateAssignmentEntity assignmentEntity = new CreateAssignmentEntity();
				BeanUtils.copyProperties(assignmentDTO, assignmentEntity);
				assignmentEntity.setCreatedDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()) + "");
				assignmentEntity.setEmail(email);
				System.out.println(assignmentEntity);
				Integer id = assignmentDAO.saveCreatedAssignment(assignmentEntity);
				if (id != null && id != 0) {
					createAssignmentMailSend.createAssignmentMailSend(email, id);
				}
				return id + "";
			}
		} catch (BeansException | DAOException e) {
			logger.error(ExceptionConstant.EXCEPTION_FROM_SERVICE + this.getClass().getSimpleName() + e.getMessage());
			throw new ServiceException(
					ExceptionConstant.EXCEPTION_FROM_SERVICE + this.getClass().getSimpleName() + e.getMessage());
		} catch (Exception e) {
			logger.error(ExceptionConstant.EXCEPTION_FROM_SERVICE + this.getClass().getSimpleName() + e.getMessage());
			throw new ServiceException(
					ExceptionConstant.EXCEPTION_FROM_SERVICE + this.getClass().getSimpleName() + e.getMessage());
		}
		return null;
	}

}
