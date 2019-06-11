package com.xworkz.assignment.restdao.search;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.assignment.entity.createassignment.CreateAssignmentEntity;
import com.xworkz.assignment.exception.DAOException;

@Repository
public class SearchRestDAOImpl implements SearchRestDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public CreateAssignmentEntity getCreatedAssignment(String email, Integer pin) throws DAOException {
		Session session = null;
		CreateAssignmentEntity assignmentEntity = null;
		int pinno = pin;
		try {
			session = sessionFactory.openSession();
			String sql = "select assign from CreateAssignmentEntity assign where assign.assignmentId=:id and assign.email=:em";
			Query query = session.createQuery(sql);
			query.setParameter("id", pinno);
			query.setParameter("em", email);
			assignmentEntity = (CreateAssignmentEntity) query.uniqueResult();
			System.err.println("assignmentEntity Data from dao : " + assignmentEntity);
			System.out.println("Object from " + query.uniqueResult());
		} catch (HibernateException e) {
			throw new DAOException(e.getMessage());
		}

		return assignmentEntity;
	}

}
