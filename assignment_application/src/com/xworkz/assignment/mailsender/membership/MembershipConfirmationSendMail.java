package com.xworkz.assignment.mailsender.membership;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.xworkz.assignment.constants.EmailConstant;
import com.xworkz.assignment.constants.ViewMessageConstant;
import com.xworkz.assignment.exception.ServiceException;

@Service
public class MembershipConfirmationSendMail {

	@Autowired
	private MailSender mailSender;

	public void sendMail(String to, String admin) throws  ServiceException {
		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(to);
			mailMessage.setCc(admin);
			mailMessage.setText(EmailConstant.MEMBER_CONFIRMATION_MSG + ViewMessageConstant.SIGN_UP_URL);
			mailMessage.setSubject(EmailConstant.SUBJECT);
			mailSender.send(mailMessage);
		} catch (MailException e) {
			throw new ServiceException(e.getMessage());
		}

	}

}
