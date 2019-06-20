package com.xworkz.assignment.mailsender.assign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.xworkz.assignment.constants.EmailConstant;
import com.xworkz.assignment.constants.ExceptionConstant;
import com.xworkz.assignment.entity.createassignment.CreateAssignmentEntity;
import com.xworkz.assignment.exception.ServiceException;

@Service
public class AssignToStudent {

	@Autowired
	private MailSender mailSender;
	private static Logger logger = LoggerFactory.getLogger(AssignToStudent.class);

	public AssignToStudent() {
		logger.info("created : " + this.getClass().getSimpleName());
	}

	public void sendMail(String[] emailList, CreateAssignmentEntity createAssignmentEntity) throws ServiceException {
		try {
			String sendText = EmailConstant.SEND_TO_STUDENT + EmailConstant.ASSIGN_ID
					+ createAssignmentEntity.getAssignmentId() + EmailConstant.COURSE_NAME
					+ createAssignmentEntity.getCourseName() + EmailConstant.TOPIC_NAME
					+ createAssignmentEntity.getTopicName() + EmailConstant.DESCRIPTION
					+ createAssignmentEntity.getTopicName() + EmailConstant.LAST_DATE
					+ createAssignmentEntity.getLastDate();
			for (String emst : emailList) {
				SimpleMailMessage mailMessage = new SimpleMailMessage();
				mailMessage.setTo(emst);
				mailMessage.setSubject(EmailConstant.SUBJECT);
				mailMessage.setText(sendText);
				mailSender.send(mailMessage);
				logger.info(EmailConstant.MAIL_SUCCESSFUL);

			}
		} catch (MailException e) {
			logger.error(ExceptionConstant.EXCEPTION_FROM_SERVICE + this.getClass().getSimpleName() + e.getMessage());
			throw new ServiceException(
					ExceptionConstant.EXCEPTION_FROM_SERVICE + this.getClass().getSimpleName() + e.getMessage());
		}

	}

}
