package com.xworkz.assignment.mailsender.createassignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class CreateAssignmentMailSend {

	@Autowired
	private MailSender mailSenderImpl;

	public void createAssignmentMailSend(String to, Integer pin) {
		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(to);
			mailMessage.setSubject("Assignment Management");
			mailMessage.setText("Welcome to Assignment Management \n" + "Your Assignment creation is sucessful \n"
					+ "Assignment Pin : " + pin);
			mailSenderImpl.send(mailMessage);

		} catch (MailException e) {
			e.printStackTrace();
		}
	}

}
