package com.xworkz.assignment.service.changepassword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.xworkz.assignment.constants.ExceptionConstant;
import com.xworkz.assignment.dao.changepassword.IChangePasswordDAO;
import com.xworkz.assignment.dao.getadminentitybyemail.IGetAdminEntityByEmailDAO;
import com.xworkz.assignment.dto.changepassword.ChangePasswordDTO;
import com.xworkz.assignment.entity.admin.AdminEntity;
import com.xworkz.assignment.exception.DAOException;
import com.xworkz.assignment.exception.ServiceException;
import com.xworkz.assignment.mailsender.changepassword.ChangePasswordMailSend;

@Service
public class ChangePasswordServiceImpl implements IChangePasswordService {

	@Autowired
	private IGetAdminEntityByEmailDAO adminEntityByEmailDAO;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private IChangePasswordDAO changePasswordDAO;
	@Autowired
	private ChangePasswordMailSend changePasswordMailSend;

	public ChangePasswordServiceImpl() {
		System.out.println("created : " + this.getClass().getSimpleName());
	}

	@Override
	public boolean changePassword(ChangePasswordDTO changePasswordDTO) throws ServiceException {
		System.out.println("invoked changePassword from " + this.getClass().getSimpleName());
		try {
			String email = changePasswordDTO.getUserName();
			String oldPass = changePasswordDTO.getOldPassword();
			String newPass = changePasswordDTO.getNewPassword();
			AdminEntity adminEntity;

			adminEntity = adminEntityByEmailDAO.getEntityByEmail(email);

			if (adminEntity != null) {
				if (passwordEncoder.matches(oldPass, adminEntity.getPassword())) {
					adminEntity.setPassword(passwordEncoder.encode(newPass));
					adminEntity.setFirstLogin(false);
					boolean result = changePasswordDAO.changePassword(adminEntity);
					if (result) {
						try {
							changePasswordMailSend.createAssignmentMailSend(email, newPass);
						} catch (ServiceException e) {
							throw new ServiceException(ExceptionConstant.EXCEPTION_FROM_SERVICE
									+ this.getClass().getSimpleName() + e.getMessage());
						}
					}
					return result;
				}
			}

		} catch (DAOException e) {
			throw new ServiceException(
					ExceptionConstant.EXCEPTION_FROM_SERVICE + this.getClass().getSimpleName() + e.getMessage());
		}
		return false;

	}
}
