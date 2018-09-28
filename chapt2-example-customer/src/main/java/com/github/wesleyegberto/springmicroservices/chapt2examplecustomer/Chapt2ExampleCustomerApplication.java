package com.github.wesleyegberto.springmicroservices.chapt2examplecustomer;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.wesleyegberto.springmicroservices.chapt2examplecustomer.customer.control.CustomerRespository;
import com.github.wesleyegberto.springmicroservices.chapt2examplecustomer.customer.entity.Customer;
import com.github.wesleyegberto.springmicroservices.chapt2examplecustomer.notification.control.NotificationSender;

@SpringBootApplication
public class Chapt2ExampleCustomerApplication {
	public static void main(String[] args) {
		SpringApplication.run(Chapt2ExampleCustomerApplication.class, args);
	}

	@Bean
	Queue queue() {
		return new Queue(NotificationSender.CUSTOMER_NOTIFICATION_QUEUE, true);
	}

	@Bean
	CommandLineRunner init(CustomerRespository repo) {
		return (evt) -> {
			repo.save(new Customer("Adam", "adam@boot.com"));
			repo.save(new Customer("John", "john@boot.com"));
			repo.save(new Customer("Smith", "smith@boot.com"));
			repo.save(new Customer("Edgar", "edgar@boot.com"));
			repo.save(new Customer("Martin", "martin@boot.com"));
			repo.save(new Customer("Tom", "tom@boot.com"));
			repo.save(new Customer("Sean", "sean@boot.com"));
		};
	}
}
