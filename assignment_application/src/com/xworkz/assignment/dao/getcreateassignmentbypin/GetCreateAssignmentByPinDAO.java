package com.xworkz.assignment.dao.getcreateassignmentbypin;

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
public class GetCreateAssignmentByPinDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private static Logger logger = LoggerFactory.getLogger(GetCreateAssignmentByPinDAO.class);

	public GetCreateAssignmentByPinDAO() {
		logger.info("created : " + this.getClass().getSimpleName());
	}

	public CreateAssignmentEntity getCreateAssignmentEntity(Integer pin) throws DAOException {

		Session session = null;
		CreateAssignmentEntity createAssignmentEntity = null;
		try {
			String sql = "select entity from CreateAssignmentEntity entity where assignmentId=:pn";
			session = sessionFactory.openSession();
			Query query = session.createQuery(sql);
			query.setParameter("pn", pin);
			createAssignmentEntity = (CreateAssignmentEntity) query.uniqueResult();
		} catch (HibernateException e) {
			logger.error(ExceptionConstant.EXCEPTION_FROM_DAO + this.getClass().getSimpleName() + e.getMessage());
			throw new DAOException(
					ExceptionConstant.EXCEPTION_FROM_DAO + this.getClass().getSimpleName() + e.getMessage());
		} catch (Exception e) {
			logger.error(ExceptionConstant.EXCEPTION_FROM_DAO + this.getClass().getSimpleName() + e.getMessage());
			throw new DAOException(
					ExceptionConstant.EXCEPTION_FROM_DAO + this.getClass().getSimpleName() + e.getMessage());
		}
		return createAssignmentEntity;
	}

}
