package com.xworkz.assignment.service.settings;

import com.xworkz.assignment.dto.settings.SettingsDTO;
import com.xworkz.assignment.exception.ServiceException;

public interface ISettingsService {

	public Boolean updateSettings(SettingsDTO settingsDTO, String ipAddress) throws ServiceException;

}
