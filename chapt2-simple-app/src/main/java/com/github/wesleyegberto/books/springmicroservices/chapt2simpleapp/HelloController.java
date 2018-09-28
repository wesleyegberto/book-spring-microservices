package com.github.wesleyegberto.books.springmicroservices.chapt2simpleapp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@RequestMapping("/")
	Greet greet() {
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