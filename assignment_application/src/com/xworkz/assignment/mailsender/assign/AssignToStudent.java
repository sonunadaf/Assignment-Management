package com.xworkz.assignment.mailsender.assign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.xworkz.assignment.entity.createassignment.CreateAssignmentEntity;

@Service
public class AssignToStudent {

	@Autowired
	private MailSender mailSender;
	private static Logger logger = LoggerFactory.getLogger(AssignToStudent.class);

	public AssignToStudent() {
		logger.info("created : " + this.getClass().getSimpleName());
	}

	public void sendMail(String[] emailList, CreateAssignmentEntity createAssignmentEntity) {
		logger.info("mail sent method  invoked");
		try {
			String sendText = "Dear Students \n              You have Assigned assignment check and upload before time line \n \n"
					+ "              Assign Id    : " + createAssignmentEntity.getAssignmentId() + "\n"
					+ "              Course Name  : " + createAssignmentEntity.getCourseName() + "\n"
					+ "              Topic Name   : " + createAssignmentEntity.getTopicName() + "\n"
					+ "              Description  : " + createAssignmentEntity.getTopicName() + "\n"
					+ "              Last Date    : " + createAssignmentEntity.getLastDate();
			for (String emst : emailList) {
				SimpleMailMessage mailMessage = new SimpleMailMessage();
				mailMessage.setTo(emst);
				mailMessage.setSubject("Assignment Management (Todays task)");
				mailMessage.setText(sendText);
				mailSender.send(mailMessage);
				logger.info("mail sent successful");

			}
		} catch (MailException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

	}

}
