package com.xworkz.assignment.dao.getcreatedassignmentbypin;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.assignment.entity.createassignment.CreateAssignmentEntity;
import com.xworkz.assignment.exception.DAOException;

@Repository
public class GetCreatedAssignmentByPin {

	@Autowired
	private SessionFactory sessionFactory;

	public CreateAssignmentEntity getCreatedAssignment(Integer pin) throws DAOException {

		Session session = null;
		CreateAssignmentEntity createdAssignmentEntity = null;
		try {
			String hql = "select assignment from CreateAssignmentEntity assignment where assignment.assignmentId=:id";
			session = sessionFactory.openSession();
			Query query = session.createQuery(hql);
			query.setParameter("id", pin);
			createdAssignmentEntity = (CreateAssignmentEntity) query.uniqueResult();
		} catch (HibernateException e) {
			throw new DAOException(e.getMessage());
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}

		return createdAssignmentEntity;
	}

}
