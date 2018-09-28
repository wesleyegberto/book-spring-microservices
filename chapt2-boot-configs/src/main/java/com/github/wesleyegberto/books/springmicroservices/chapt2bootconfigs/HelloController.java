package com.github.wesleyegberto.books.springmicroservices.chapt2bootconfigs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);
	
	@Autowired
    Environment env;
	
	@RequestMapping("/")
	Greet greet() {
		LOG.info("=== Custom property: " + env.getProperty("bootrest.customproperty"));
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