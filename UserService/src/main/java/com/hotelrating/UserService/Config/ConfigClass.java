package com.hotelrating.UserService.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import java.util.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.web.client.RestTemplate;

import com.hotelrating.UserService.Config.Interceptors.RestInterceptors;

@Configuration
public class ConfigClass {
	
	
	@Autowired
	private ClientRegistrationRepository clientRegistrationRepository;
    @Autowired
	private OAuth2AuthorizedClientRepository auth2AuthorizedClientRepository ;
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		
	
		
		RestTemplate restTemplate=new RestTemplate();
		
		List<ClientHttpRequestInterceptor> interceptor=new ArrayList<>();
		interceptor.add(new RestInterceptors(manager(
				clientRegistrationRepository,auth2AuthorizedClientRepository
				)));
		
		restTemplate.setInterceptors(interceptor);
		
		return restTemplate;
	}
	
	
	//declare the bean of oauth2Authorized Manager
	@Bean
	public OAuth2AuthorizedClientManager manager(
			ClientRegistrationRepository clientRegistrationRepository,
			
			OAuth2AuthorizedClientRepository auth2AuthorizedClientRepository 
			) {
	
		
		OAuth2AuthorizedClientProvider provider=OAuth2AuthorizedClientProviderBuilder.builder().clientCredentials().build();
		
		DefaultOAuth2AuthorizedClientManager defaultOAuth2AuthorizedClientManager=new DefaultOAuth2AuthorizedClientManager(clientRegistrationRepository,auth2AuthorizedClientRepository);
		
		defaultOAuth2AuthorizedClientManager.setAuthorizedClientProvider(provider);
		
		return defaultOAuth2AuthorizedClientManager;
	}
	

}
