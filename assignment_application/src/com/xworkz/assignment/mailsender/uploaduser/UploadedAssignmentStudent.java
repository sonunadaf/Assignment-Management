package com.xworkz.assignment.mailsender.uploaduser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class UploadedAssignmentStudent {

	@Autowired
	private MailSender mailSender;

	public void sendMailtoStudent(String email) {

		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(email);
			mailMessage.setSubject("Assignment Management (Assignment submition)");
			mailMessage.setText("Assignment Uploaded Successful \n Thank You.");
			mailSender.send(mailMessage);
		} catch (MailException e) {
			e.printStackTrace();
		}

	}

}
