package com.github.wesleyegberto.springmicroservices.chapt2oauth2server;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Chapt2Oauth2ServerApplication.class, webEnvironment = WebEnvironment.DEFINED_PORT, properties = { "server.port=8080" })
public class Chapt2Oauth2ServerApplicationTests {
	@Test
	public void testOAuthService() {
		ResourceOwnerPasswordResourceDetails resource = new ResourceOwnerPasswordResourceDetails();
		resource.setUsername("guest");
		resource.setPassword("guest123");
		resource.setAccessTokenUri("http://localhost:8080/oauth/token");
		resource.setClientId("trustedclient");
		resource.setClientSecret("trustedclient123");
		resource.setGrantType("password");
		
		DefaultOAuth2ClientContext clientContext = new DefaultOAuth2ClientContext();
		OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resource, clientContext);
		Greet greet = restTemplate.getForObject("http://localhost:8080/", Greet.class);
		
		assertThat(greet.getMessage(), is("Hello World!"));
	}
}
