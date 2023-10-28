package com.hotelrating.UserService.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ratings {

	private String ratingid;
	private String userid;
	private String hotelid;
	private int rating; 
	private String feedback;
	
	private Hotel hotel;
	
}
