package com.github.wesleyegberto.springmicroservices.chapt2examplecustomer.notification.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
// @Lazy
public class NotificationSender {
	private static final Logger LOG = LoggerFactory.getLogger(NotificationSender.class);
	
	public static final String CUSTOMER_NOTIFICATION_QUEUE = "customer-notification-queue";

	private RabbitMessagingTemplate template;

	@Autowired
	public NotificationSender(RabbitMessagingTemplate template) {
		this.template = template;
	}

	public void send(String email) {
		LOG.info("Sending email {} to notification.", email);
		template.convertAndSend(CUSTOMER_NOTIFICATION_QUEUE, email);
	}
}
