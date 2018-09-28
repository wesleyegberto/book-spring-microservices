package com.github.wesleyegberto.springmicroservices.chapt2examplenotification.notificator.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class Mailer {
	@Autowired
	private MailSender mailSender;

	public void sendMail(String email) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(email);
		mailMessage.setSubject("Registration");
		mailMessage.setText("Successfully registered!");
		mailSender.send(mailMessage);
	}
}