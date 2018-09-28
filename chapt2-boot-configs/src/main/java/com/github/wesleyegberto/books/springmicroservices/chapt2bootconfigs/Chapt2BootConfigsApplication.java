package com.github.wesleyegberto.books.springmicroservices.chapt2bootconfigs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity
public class Chapt2BootConfigsApplication {
	public static void main(String[] args) {
		SpringApplication.run(Chapt2BootConfigsApplication.class, args);
	}
}
