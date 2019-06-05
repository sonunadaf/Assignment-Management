package com.xworkz.assignment.mailsender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class MailSenderToUser {

	@Autowired
	private MailSender mailSenderImpl;

	public MailSenderToUser() {
		System.out.println("created : " + this.getClass().getSimpleName());
	}

	public void sendMail(String to, String password) {
		try {
			System.out.println("MailSender : " + mailSenderImpl);
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(to);
			mailMessage.setSubject("Password sending");
			mailMessage.setText("Password and user management");
			System.out.println("MailSender implementation : " + mailSenderImpl);
			mailSenderImpl.send(mailMessage);
			
		} catch (MailException e) {
			e.printStackTrace();
		}
	}

}
