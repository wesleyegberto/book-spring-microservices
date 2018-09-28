package com.github.wesleyegberto.springmicroservices.chapt2messaging;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Chapt2MessagingApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chapt2MessagingApplication.class, args);
	}

	@Bean
	Queue queue() {
		return new Queue("TestQ", false);
	}
}

@Component
class SenderRunner implements CommandLineRunner {
	@Autowired
	Sender sender;

	@Override
	public void run(String... args) throws Exception {
		sender.send("Hello Messaging..." + System.currentTimeMillis() + "!!!");
	}
}

@Component
class Sender {
	@Autowired
	RabbitMessagingTemplate template;

	public void send(String message) {
		template.convertAndSend("TestQ", message);
	}
}

@Component
class Receiver {
	@RabbitListener(queues = "TestQ")
	public void processMessage(String content) {
		System.out.println(content);
	}
}