package com.xworkz.assignment.service.createassignment;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.assignment.dao.createassignment.ICreateAssignmentDAO;
import com.xworkz.assignment.dto.createassignment.CreateAssignmentDTO;
import com.xworkz.assignment.entity.createassignment.CreateAssignmentEntity;

@Service
public class CreateAssignentServiceImpl implements ICreateAssignentService {

	@Autowired
	private ICreateAssignmentDAO assignmentDAO;

	public CreateAssignentServiceImpl() {
		System.out.println("created : " + this.getClass().getSimpleName());
	}

	@Override
	public String createAssignment(String email, CreateAssignmentDTO assignmentDTO) {
		System.out.println("emial from createAssignment : " + email);
		System.out.println("AssignmentDTO from : " + assignmentDTO);
		if (assignmentDTO != null) {
			CreateAssignmentEntity assignmentEntity = new CreateAssignmentEntity();
			BeanUtils.copyProperties(assignmentDTO, assignmentEntity);
			assignmentEntity.setCreatedDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()) + "");
			assignmentEntity.setEmail(email);
			System.out.println(assignmentEntity);
			Integer id = assignmentDAO.saveCreatedAssignment(assignmentEntity);
			return id + "";
		}
		return null;
	}

}
