package com.hotelrating.RatingServices.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelrating.RatingServices.Model.Rating;
import com.hotelrating.RatingServices.Repository.RatingRepository;
import com.hotelrating.RatingServices.Services.RatingServices;


@Service
public class RatingServicesImpl implements RatingServices {

	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public Rating createRating(Rating rating) {
	
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getRatings() {
		
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingByUserID(String userid) {
		
		return ratingRepository.findByuserid(userid);
	}

	@Override
	public List<Rating> getRatingByHotelID(String hotelid) {
		
		return ratingRepository.findByhotelid(hotelid);
	}
}
