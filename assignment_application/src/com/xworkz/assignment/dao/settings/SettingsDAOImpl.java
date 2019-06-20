package com.xworkz.assignment.dao.settings;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.assignment.constants.ExceptionConstant;
import com.xworkz.assignment.entity.admin.AdminEntity;
import com.xworkz.assignment.entity.settings.SettingsEntity;
import com.xworkz.assignment.exception.DAOException;
import com.xworkz.assignment.service.settings.SettingsServiceImpl;

@Repository
public class SettingsDAOImpl implements ISettingsDAO {

	@Autowired
	private SessionFactory sessionFactory;
	private static Logger logger = LoggerFactory.getLogger(SettingsServiceImpl.class);

	@Override
	public void updateSettings(SettingsEntity settingsEntity) throws DAOException {
		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(settingsEntity);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			logger.error(ExceptionConstant.EXCEPTION_FROM_DAO + this.getClass().getSimpleName() + e.getMessage());
			throw new DAOException(e.getMessage());
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			logger.error(ExceptionConstant.EXCEPTION_FROM_DAO + this.getClass().getSimpleName() + e.getMessage());
			throw new DAOException(e.getMessage());
		} finally {
			session.close();
		}

	}

	@Override
	public void updateAdmin(AdminEntity adminEntity) throws DAOException {
		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(adminEntity);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			logger.error(ExceptionConstant.EXCEPTION_FROM_DAO + this.getClass().getSimpleName() + e.getMessage());
			throw new DAOException(
					ExceptionConstant.EXCEPTION_FROM_DAO + this.getClass().getSimpleName() + e.getMessage());
		} catch (Exception e) {
			transaction.rollback();

			logger.error(ExceptionConstant.EXCEPTION_FROM_DAO + this.getClass().getSimpleName() + e.getMessage());
			throw new DAOException(
					ExceptionConstant.EXCEPTION_FROM_DAO + this.getClass().getSimpleName() + e.getMessage());
		} finally {
			session.close();
		}
	}

}
