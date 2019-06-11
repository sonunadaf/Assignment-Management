package com.xworkz.assignment.dao.settings;

import com.xworkz.assignment.entity.admin.AdminEntity;
import com.xworkz.assignment.entity.settings.SettingsEntity;
import com.xworkz.assignment.exception.DAOException;

public interface ISettingsDAO {

	public void updateSettings(SettingsEntity settingsEntity) throws DAOException;

	public void updateAdmin(AdminEntity adminEntity) throws DAOException;

}
