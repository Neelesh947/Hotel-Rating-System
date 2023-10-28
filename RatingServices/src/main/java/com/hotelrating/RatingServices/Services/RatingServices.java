package com.hotelrating.RatingServices.Services;

import java.util.List;

import com.hotelrating.RatingServices.Model.Rating;

public interface RatingServices {

	
	//create
	Rating createRating(Rating rating);
	
	//get all rating
	List<Rating> getRatings();	
	
	
	//get all by user id
	List<Rating> getRatingByUserID(String userid);
	
	
	// get all by hotel
	List<Rating> getRatingByHotelID(String hotelid);
}
