package com.github.wesleyegberto.springmicroservices.chapt2examplenotification;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.wesleyegberto.springmicroservices.chapt2examplenotification.notificator.control.NewRegistrationListener;

@SpringBootApplication
public class Chapt2ExampleNotificationApplication {
	public static void main(String[] args) {
		SpringApplication.run(Chapt2ExampleNotificationApplication.class, args);
	}

	@Bean
	Queue queue() {
		return new Queue(NewRegistrationListener.CUSTOMER_NOTIFICATION_QUEUE, true);
	}
}
