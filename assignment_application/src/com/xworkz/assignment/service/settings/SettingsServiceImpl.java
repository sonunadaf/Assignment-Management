package com.xworkz.assignment.service.settings;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.assignment.constants.ExceptionConstant;
import com.xworkz.assignment.dao.getadminentitybyemail.IGetAdminEntityByEmailDAO;
import com.xworkz.assignment.dao.settings.ISettingsDAO;
import com.xworkz.assignment.dto.settings.SettingsDTO;
import com.xworkz.assignment.entity.admin.AdminEntity;
import com.xworkz.assignment.entity.settings.SettingsEntity;
import com.xworkz.assignment.exception.DAOException;
import com.xworkz.assignment.exception.ServiceException;

@Service
public class SettingsServiceImpl implements ISettingsService {

	@Autowired
	private ISettingsDAO settingsDAO;
	@Autowired
	private IGetAdminEntityByEmailDAO adminEntityByEmailDAO;
	private static Logger logger = LoggerFactory.getLogger(SettingsServiceImpl.class);

	public SettingsServiceImpl() {
		logger.info("created : " + this.getClass().getSimpleName());
	}

	@Override
	public Boolean updateSettings(SettingsDTO settingsDTO, String ipAddress) throws ServiceException {
		boolean update = false;
		try {

			String fName = settingsDTO.getFirstName();
			String lName = settingsDTO.getLastName();
			String phoneNumber = settingsDTO.getPhoneNUmber();
			AdminEntity adminEntity = adminEntityByEmailDAO.getEntityByEmail(settingsDTO.getEmail());
			if (fName != null && fName != "" && !fName.equalsIgnoreCase(adminEntity.getFirstName())) {
				SettingsEntity settingsEntity = new SettingsEntity();
				settingsEntity.setEntity(adminEntity.getClass().getSimpleName());
				settingsEntity.setEntityId(adminEntity.getId());
				settingsEntity.setDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()) + "");
				settingsEntity.setProperty("First Name");
				settingsEntity.setOldValue(adminEntity.getFirstName());
				settingsEntity.setNewValue(settingsDTO.getFirstName());
				settingsEntity.setIpAddress(ipAddress);
				settingsDAO.updateSettings(settingsEntity);
				adminEntity.setFirstName(fName);
				update = true;

			}
			if (lName != null && lName != "" && !lName.equalsIgnoreCase(adminEntity.getLastName())) {
				SettingsEntity settingsEntity = new SettingsEntity();
				settingsEntity.setEntity(adminEntity.getClass().getSimpleName());
				settingsEntity.setEntityId(adminEntity.getId());
				settingsEntity.setDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()) + "");
				settingsEntity.setProperty("Last Name");
				settingsEntity.setOldValue(adminEntity.getLastName());
				settingsEntity.setNewValue(settingsDTO.getLastName());
				settingsEntity.setIpAddress(ipAddress);
				settingsDAO.updateSettings(settingsEntity);
				adminEntity.setLastName(lName);

				update = true;

			}
			if (phoneNumber != null && phoneNumber != ""
					&& !phoneNumber.equalsIgnoreCase(adminEntity.getContactNumber())) {
				SettingsEntity settingsEntity = new SettingsEntity();
				settingsEntity.setEntity(adminEntity.getClass().getSimpleName());
				settingsEntity.setEntityId(adminEntity.getId());
				settingsEntity.setDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()) + "");
				settingsEntity.setProperty("Phone Number");
				settingsEntity.setOldValue(adminEntity.getContactNumber());
				settingsEntity.setNewValue(settingsDTO.getPhoneNUmber());
				settingsEntity.setIpAddress(ipAddress);
				settingsDAO.updateSettings(settingsEntity);
				adminEntity.setContactNumber(phoneNumber);
				update = true;
			}
			if (update) {
				settingsDAO.updateAdmin(adminEntity);
			}

		} catch (DAOException e) {
			logger.error(ExceptionConstant.EXCEPTION_FROM_SERVICE + this.getClass().getSimpleName() + e.getMessage());
			throw new ServiceException(
					ExceptionConstant.EXCEPTION_FROM_SERVICE + this.getClass().getSimpleName() + e.getMessage());
		} catch (Exception e) {
			logger.error(ExceptionConstant.EXCEPTION_FROM_SERVICE + this.getClass().getSimpleName() + e.getMessage());
			throw new ServiceException(
					ExceptionConstant.EXCEPTION_FROM_SERVICE + this.getClass().getSimpleName() + e.getMessage());
		}

		return update;

	}

	@Override
	public AdminEntity getAdminByEmail(String email) throws ServiceException {
		AdminEntity adminEntity = null;
		try {
			adminEntity = adminEntityByEmailDAO.getEntityByEmail(email);
		} catch (DAOException e) {

			logger.error(ExceptionConstant.EXCEPTION_FROM_SERVICE + this.getClass().getSimpleName() + e.getMessage());
			throw new ServiceException(
					ExceptionConstant.EXCEPTION_FROM_SERVICE + this.getClass().getSimpleName() + e.getMessage());
		}
		return adminEntity;
	}

}
