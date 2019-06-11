package com.xworkz.assignment.service.settings;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Boolean updateSettings(SettingsDTO settingsDTO) throws ServiceException {
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
				settingsDAO.updateSettings(settingsEntity);
				adminEntity.setContactNumber(phoneNumber);
				update = true;
			}
			if (update) {
				settingsDAO.updateAdmin(adminEntity);
			}

		} catch (DAOException e) {
			logger.error("Exception from  SettingsServiceImpl " + e.getMessage());
			throw new ServiceException(e.getMessage());
		} catch (Exception e) {
			logger.error("Exception from  SettingsServiceImpl " + e.getMessage());
			throw new ServiceException(e.getMessage());
		}

		return update;

	}

}
