package com.xworkz.assignment.service.createassignment;

import org.springframework.stereotype.Service;

import com.xworkz.assignment.dto.createassignment.CreateAssignmentDTO;
import com.xworkz.assignment.exception.ServiceException;

@Service
public interface ICreateAssignentService {
	
	public String createAssignment(String email,CreateAssignmentDTO assignmentDTO) throws ServiceException;
}
