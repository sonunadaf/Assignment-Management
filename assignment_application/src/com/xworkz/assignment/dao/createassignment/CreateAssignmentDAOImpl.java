package com.xworkz.assignment.dao.createassignment;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.assignment.constants.ExceptionConstant;
import com.xworkz.assignment.entity.createassignment.CreateAssignmentEntity;
import com.xworkz.assignment.exception.DAOException;

@Repository
public class CreateAssignmentDAOImpl implements ICreateAssignmentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Integer saveCreatedAssignment(CreateAssignmentEntity assignmentEntity) throws DAOException {
		Session session = null;
		Serializable serializable = null;

		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			serializable = session.save(assignmentEntity);
			transaction.commit();
		} catch (HibernateException e) {
			throw new DAOException(
					ExceptionConstant.EXCEPTION_FROM_DAO + this.getClass().getSimpleName() + e.getMessage());
		} catch (Exception e) {
			throw new DAOException(
					ExceptionConstant.EXCEPTION_FROM_DAO + this.getClass().getSimpleName() + e.getMessage());
		} finally {
			session.close();
		}

		return (Integer) serializable;
	}

}
