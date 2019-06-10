package com.xworkz.assignment.service.createassignment;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.assignment.dao.createassignment.ICreateAssignmentDAO;
import com.xworkz.assignment.dto.createassignment.CreateAssignmentDTO;
import com.xworkz.assignment.entity.createassignment.CreateAssignmentEntity;

@Service
public class CreateAssignentServiceImpl implements ICreateAssignentService {

	@Autowired
	private ICreateAssignmentDAO assignmentDAO;

	private static Logger logger = LoggerFactory.getLogger(CreateAssignentServiceImpl.class);

	public CreateAssignentServiceImpl() {
		System.out.println("created : " + this.getClass().getSimpleName());
		logger.info("Create By Logger : " + this.getClass().getSimpleName());
	}

	@Override
	public String createAssignment(String email, CreateAssignmentDTO assignmentDTO) {
		System.out.println("emial from createAssignment : " + email);
		System.out.println("AssignmentDTO from : " + assignmentDTO);
		try {
			if (assignmentDTO != null) {
				CreateAssignmentEntity assignmentEntity = new CreateAssignmentEntity();
				BeanUtils.copyProperties(assignmentDTO, assignmentEntity);
				assignmentEntity.setCreatedDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()) + "");
				assignmentEntity.setEmail(email);
				System.out.println(assignmentEntity);
				Integer id = assignmentDAO.saveCreatedAssignment(assignmentEntity);
				return id + "";
			}
		} catch (BeansException e) {
			e.printStackTrace();
		}
		return null;
	}

}
