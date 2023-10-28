package com.hotelrating.RatingServices.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hotelrating.RatingServices.Model.Rating;

@Repository
public interface RatingRepository extends MongoRepository<Rating, String>{

	
	//custom finder methods
	List<Rating> findByuserid(String userid);
	
	List<Rating> findByhotelid(String hotelid);
}
