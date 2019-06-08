package com.xworkz.assignment.dao.createassignment;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.assignment.entity.createassignment.CreateAssignmentEntity;

@Repository
public class CreateAssignmentDAOImpl implements ICreateAssignmentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Integer saveCreatedAssignment(CreateAssignmentEntity assignmentEntity) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Serializable serializable = session.save(assignmentEntity);
		transaction.commit();

		return (Integer) serializable;
	}

}
