package com.hotelrating.RatingServices.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelrating.RatingServices.Model.Rating;
import com.hotelrating.RatingServices.Services.RatingServices;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	private RatingServices ratingService;

	@PostMapping
	public ResponseEntity<Rating> createRatings(@RequestBody Rating rating)
	{
		Rating rating1=ratingService.createRating(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(rating1);
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRatings()
	{
		List<Rating> allrating=ratingService.getRatings();
		return ResponseEntity.ok(allrating);
	}
	
	@GetMapping("/users/{userid}")
	public ResponseEntity<List<Rating>> getRatingByUserID(@PathVariable String userid)
	{
		List<Rating> userRating=ratingService.getRatingByUserID(userid);
		return ResponseEntity.ok(userRating);
	}
	
	@GetMapping("/hotels/{hotelid}")
	public ResponseEntity<List<Rating>> getRatingByHotelID(@PathVariable String hotelid)
	{
		List<Rating> hotelRating=ratingService.getRatingByHotelID(hotelid);
		return ResponseEntity.ok(hotelRating);
	}
	
	
}
