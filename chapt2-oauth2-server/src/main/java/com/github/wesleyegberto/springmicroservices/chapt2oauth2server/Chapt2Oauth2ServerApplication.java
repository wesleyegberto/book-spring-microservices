package com.github.wesleyegberto.springmicroservices.chapt2oauth2server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// creates an authorization server with an in-memory repository to store client tokens and provide clients with a username, password, client ID, and secret
@EnableAuthorizationServer
// used to access the tokens, this enables a spring security filter that is authenticated via an incoming OAuth2 token
@EnableResourceServer
// usually the two annotations above are in differents servers
@SpringBootApplication
public class Chapt2Oauth2ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chapt2Oauth2ServerApplication.class, args);
	}
}

class MvcConfigurer implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("*")
			.allowedOrigins("*")
			.allowedHeaders("*")
			.allowedMethods("GET", "POST");
	}
}