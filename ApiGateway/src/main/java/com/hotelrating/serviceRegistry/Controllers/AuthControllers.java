package com.hotelrating.serviceRegistry.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelrating.serviceRegistry.Model.AuthResponse;

import java.util.*;
import java.util.stream.*;

@RestController
@RequestMapping("/auth")
public class AuthControllers {

	private Logger logger=LoggerFactory.getLogger(AuthControllers.class);
	
	@GetMapping("/login")
	public ResponseEntity<AuthResponse> login(
		 @RegisteredOAuth2AuthorizedClient("okta")	OAuth2AuthorizedClient client,
		 @AuthenticationPrincipal OidcUser user,
		 Model model
			){
		
		
		//creating auth response object
		AuthResponse authResponse=new AuthResponse();
		
		
		//setting email to auth response
		authResponse.setUserid(user.getEmail());
		
		//setting token to auth response
		authResponse.setAccessToken(client.getAccessToken().getTokenValue());
		
		authResponse.setRefreshToken(client.getRefreshToken().getTokenValue());
		
		authResponse.setExpire(client.getAccessToken().getExpiresAt().getEpochSecond());
		
		List<String> authorities= user.getAuthorities().stream().map(GrantedAuthority ->{ 
			return GrantedAuthority.getAuthority();
			}).collect(Collectors.toList());
		
		authResponse.setAuthorities(authorities);
		
		
		return new ResponseEntity<>(authResponse, HttpStatus.OK);
	}
}
