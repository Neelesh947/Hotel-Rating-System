package com.hotelrating.UserService.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.hotelrating.UserService.Model.Ratings;

@FeignClient(name="RATING-SERVICE")
public interface ratingService {
	
    // get 
	@GetMapping("/rating/{ratingid}")
	Ratings getRating(@PathVariable String ratingid);
	
	//post
	@PostMapping("/ratings")
	Ratings createRating(Ratings values);
	
	//put
	@PutMapping("/ratings/{ratingid}")
	public Ratings updateRating(@PathVariable String ratingid,  Ratings rating);
	
	
	//delete
	@DeleteMapping("/ratings/{ratingid}")
	public void deleteRatings(@PathVariable String ratingid);
	
	
}
