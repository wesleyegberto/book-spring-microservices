package com.github.wesleyegberto.books.springmicroservices.chapt2simpleapp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Chapt2SimpleAppApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class Chapt2SimpleAppApplicationTests {
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void testVanillaService() {
		Greet greet = restTemplate.getForObject("/", Greet.class);
		assertThat("Hello World!", is(greet.getMessage()));
	}
}
