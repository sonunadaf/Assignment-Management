package com.xworkz.assignment.restdao.searchall;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.assignment.entity.createassignment.CreateAssignmentEntity;
import com.xworkz.assignment.exception.DAOException;

@Repository
public class SearchAllDAOImpl implements ISearchAllDAO {

	@Autowired
	private SessionFactory sessionFactory;
	private static Logger logger = LoggerFactory.getLogger(SearchAllDAOImpl.class);

	public SearchAllDAOImpl() {
		logger.info("created : " + this.getClass().getSimpleName());
	}

	@Override
	public List<CreateAssignmentEntity> getAllAssignmentEntities(String email) throws DAOException {
		Session session = null;
		List<CreateAssignmentEntity> assignmentList = null;
		try {
			String hql = "select assignment from CreateAssignmentEntity assignment where assignment.email=:em";
			session = sessionFactory.openSession();
			Query query = session.createQuery(hql);
			query.setParameter("em", email);
			assignmentList =query.list();
		} catch (HibernateException e) {
			logger.error("exception from DAO : " + e.getMessage());
			throw new DAOException(e.getMessage());
		} catch (Exception e) {
			logger.error("exception from DAO : " + e.getMessage());
			throw new DAOException(e.getMessage());
		}

		return assignmentList;
	}

}
