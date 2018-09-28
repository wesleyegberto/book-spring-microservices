package com.github.wesleyegberto.books.springmicroservices.chapt2bootconfigs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Base64;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.wesleyegberto.books.springmicroservices.chapt2bootconfigs.Chapt2BootConfigsApplication;
import com.github.wesleyegberto.books.springmicroservices.chapt2bootconfigs.Greet;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Chapt2BootConfigsApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class Chapt2BootConfigsApplicationTests {
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testVanillaService() {
		ResponseEntity<Greet> response = restTemplate.getForEntity("/", Greet.class);
		assertThat(response.getStatusCode(), is(HttpStatus.UNAUTHORIZED));
	}

	@Test
	public void testSecureService() {
		String plainCreds = "guest:guest123";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + new String(Base64.getEncoder().encode(plainCreds.getBytes())));
		HttpEntity<String> request = new HttpEntity<String>(headers);
		
		ResponseEntity<Greet> response = restTemplate.exchange("/", HttpMethod.GET, request, Greet.class);
		assertThat(response.getStatusCode(), is (HttpStatus.OK));
		assertThat(response.getBody().getMessage(), is("Hello World!"));
	}
}
