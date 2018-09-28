package com.github.wesleyegberto.springmicroservices.chapt2examplenotification.notificator.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NewRegistrationListener {
	private static final Logger LOG = LoggerFactory.getLogger(NewRegistrationListener.class);
	
	public static final String CUSTOMER_NOTIFICATION_QUEUE = "customer-notification-queue";

	Mailer mailer;

	@Autowired
	public NewRegistrationListener(Mailer mailer) {
		this.mailer = mailer;
	}

	@RabbitListener(queues = CUSTOMER_NOTIFICATION_QUEUE)
	public void processMessage(String email) {
		LOG.info("Sending mail to {}.", email);
		mailer.sendMail(email);
	}
}