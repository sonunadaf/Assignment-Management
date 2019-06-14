package com.xworkz.assignment.mailsender.changepassword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class ChangePasswordMailSend {
	@Autowired
	private MailSender mailSenderImpl;

	public void createAssignmentMailSend(String to, String pass) {
		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(to);
			mailMessage.setSubject("Assignment Management");
			mailMessage.setText("Welcome to Assignment Manageme	nt \n" + "Change Password is sucessful \n"
					+ "New Password  : " + pass);
			mailSenderImpl.send(mailMessage);

		} catch (MailException e) {
			e.printStackTrace();
		}
	}
}
