package com.xworkz.assignment.dao.getcreatedassignmentbypin;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.assignment.constants.ExceptionConstant;
import com.xworkz.assignment.entity.createassignment.CreateAssignmentEntity;
import com.xworkz.assignment.exception.DAOException;

@Repository
public class GetCreatedAssignmentByPin {

	@Autowired
	private SessionFactory sessionFactory;
	private static Logger logger = LoggerFactory.getLogger(GetCreatedAssignmentByPin.class);

	public CreateAssignmentEntity getCreatedAssignment(Integer pin, String email) throws DAOException {

		Session session = null;
		CreateAssignmentEntity createdAssignmentEntity = null;
		try {
			String hql = "select assignment from CreateAssignmentEntity assignment where assignment.assignmentId=:id";
			session = sessionFactory.openSession();
			Query query = session.createQuery(hql);
			query.setParameter("id", pin);
			createdAssignmentEntity = (CreateAssignmentEntity) query.uniqueResult();
		} catch (HibernateException e) {
			logger.error(ExceptionConstant.EXCEPTION_FROM_DAO + this.getClass().getSimpleName() + e.getMessage());
			throw new DAOException(
					ExceptionConstant.EXCEPTION_FROM_DAO + this.getClass().getSimpleName() + e.getMessage());
		} catch (Exception e) {
			logger.error(ExceptionConstant.EXCEPTION_FROM_DAO + this.getClass().getSimpleName() + e.getMessage());
			throw new DAOException(
					ExceptionConstant.EXCEPTION_FROM_DAO + this.getClass().getSimpleName() + e.getMessage());
		}

		return createdAssignmentEntity;
	}

}
