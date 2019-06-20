package com.xworkz.assignment.dao.getsolvedassignment;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.assignment.constants.ExceptionConstant;
import com.xworkz.assignment.exception.DAOException;

@Repository
public class GetSolvedAssignmentByPinDAOImpl implements GetSolvedAssignmentByPinDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private static Logger logger = LoggerFactory.getLogger(GetSolvedAssignmentByPinDAOImpl.class);

	@Override
	public List<?> getSolvedAssignmentbyPin(String email) throws DAOException {
		String hql = "select stupload from UploadStudentAssignmentEntity stupload"
				+ " where stupload.pin IN(select crst.assignmentId from CreateAssignmentEntity crst where crst.email=:em)";
		Session session = null;
		List list = null;
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery(hql);
			query.setParameter("em", email);
			list = query.list();
		} catch (HibernateException e) {
			logger.error(ExceptionConstant.EXCEPTION_FROM_DAO + this.getClass().getSimpleName() + e.getMessage());
			throw new DAOException(
					ExceptionConstant.EXCEPTION_FROM_DAO + this.getClass().getSimpleName() + e.getMessage());
		}

		return list;
	}

}
