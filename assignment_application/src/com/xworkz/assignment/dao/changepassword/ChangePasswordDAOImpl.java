package com.xworkz.assignment.dao.changepassword;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.assignment.constants.ExceptionConstant;
import com.xworkz.assignment.entity.admin.AdminEntity;
import com.xworkz.assignment.exception.DAOException;

@Repository
public class ChangePasswordDAOImpl implements IChangePasswordDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean changePassword(AdminEntity adminEntity) throws DAOException {

		Session session = null;
		Transaction transaction = null;
		boolean status = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(adminEntity);
			transaction.commit();
			status = true;
		} catch (HibernateException e) {
			transaction.rollback();
			throw new DAOException(
					ExceptionConstant.EXCEPTION_FROM_DAO + this.getClass().getSimpleName() + e.getMessage());

		} catch (Exception e) {
			transaction.rollback();
			throw new DAOException(
					ExceptionConstant.EXCEPTION_FROM_DAO + this.getClass().getSimpleName() + e.getMessage());

		} finally {
			session.close();
		}
		return status;
	}

}
