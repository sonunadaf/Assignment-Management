package com.xworkz.assignment.dao.signup;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.assignment.entity.admin.AdminEntity;
import com.xworkz.assignment.exception.DAOException;

@Repository
public class SignUpDAO implements ISignUpDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Integer save(AdminEntity adminEntity) throws DAOException {
		Session session = null;
		Integer id = 0;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			id = (Integer) session.save(adminEntity);
			transaction.commit();
			return id;
		} catch (HibernateException e) {
			transaction.rollback();
			throw new DAOException("Exception from DAO " + e.getMessage());
		} catch (Exception e) {
			transaction.rollback();
			throw new DAOException("Exception from DAO " + e.getMessage());
		} finally {
			session.close();
		}

	}

}
