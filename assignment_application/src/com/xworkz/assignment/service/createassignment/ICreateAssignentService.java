package com.xworkz.assignment.service.createassignment;

import org.springframework.stereotype.Service;

import com.xworkz.assignment.dto.createassignment.CreateAssignmentDTO;

@Service
public interface ICreateAssignentService {
	
	public String createAssignment(String email,CreateAssignmentDTO assignmentDTO);
}
