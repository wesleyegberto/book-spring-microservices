package com.github.wesleyegberto.springmicroservices.chapt2actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.wesleyegberto.springmicroservices.chapt2actuator.health.TPSHealth;

@RestController
public class GreetingsController {
	@Autowired
	private TPSHealth health;

	@RequestMapping("/")
	Greet greet() {
		health.updateTx();
		return new Greet("Hello World!");
	}
}

class Greet {
	private String message;

	public Greet() {
	}

	public Greet(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}