package com.github.wesleyegberto.springmicroservices.chapt2swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Chapt2SwaggerApplication {
	public static void main(String[] args) {
		SpringApplication.run(Chapt2SwaggerApplication.class, args);
	}
}
