package com.hotelrating.serviceRegistry.Model;

import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {

	
	private String userid;
	private String accessToken;
	private String refreshToken;
	private long expire;
	private Collection<String> authorities;
	
}
