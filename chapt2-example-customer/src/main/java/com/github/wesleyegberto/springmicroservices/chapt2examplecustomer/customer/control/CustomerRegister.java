package com.github.wesleyegberto.springmicroservices.chapt2examplecustomer.customer.control;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.wesleyegberto.springmicroservices.chapt2examplecustomer.customer.entity.Customer;
import com.github.wesleyegberto.springmicroservices.chapt2examplecustomer.notification.control.NotificationSender;

@Service
public class CustomerRegister {
	private CustomerRespository customerRespository;
	private NotificationSender notificationSender;

	@Autowired
	CustomerRegister(CustomerRespository customerRespository, NotificationSender notificationSender) {
		this.customerRespository = customerRespository;
		this.notificationSender = notificationSender;
	}

	public Customer register(Customer customer) {
		Optional<Customer> existingCustomer = customerRespository.findByName(customer.getName());
		if (existingCustomer.isPresent()) {
			throw new RuntimeException("is already exists");
		} else {
			customerRespository.save(customer);
			notificationSender.send(customer.getEmail());
		}
		return customer;
	}
}
