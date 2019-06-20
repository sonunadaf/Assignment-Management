package com.xworkz.assignment.mailsender.createassignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.xworkz.assignment.constants.EmailConstant;
import com.xworkz.assignment.constants.ExceptionConstant;
import com.xworkz.assignment.exception.ServiceException;

@Service
public class CreateAssignmentMailSend {

	@Autowired
	private MailSender mailSenderImpl;
	private static Logger logger = LoggerFactory.getLogger(CreateAssignmentMailSend.class);

	public void createAssignmentMailSend(String to, Integer pin) throws ServiceException {
		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(to);
			mailMessage.setSubject(EmailConstant.SUBJECT);
			mailMessage.setText(EmailConstant.ASSIGNMENT_CREATION_SUCCESSFUL + EmailConstant.ASSIGNMENT_PIN + pin);
			mailSenderImpl.send(mailMessage);

		} catch (MailException e) {
			logger.error(ExceptionConstant.EXCEPTION_FROM_SERVICE + this.getClass().getSimpleName() + e.getMessage());
			throw new ServiceException(
					ExceptionConstant.EXCEPTION_FROM_SERVICE + this.getClass().getSimpleName() + e.getMessage());
		}
	}

}
