package com.hotelrating.UserService.ServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hotelrating.UserService.Exception.ResourceNotFoundException;
import com.hotelrating.UserService.Model.Hotel;
import com.hotelrating.UserService.Model.Ratings;
import com.hotelrating.UserService.Model.User;
import com.hotelrating.UserService.Repository.UserRepository;
import com.hotelrating.UserService.Service.UserService;
import com.hotelrating.UserService.external.HotelServices;
import com.hotelrating.UserService.external.ratingService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelServices hotelServices;
	
	private ratingService ratingService;
	
	//private Logger log=LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	public User saveUser(User user) {
		String randomUserId=UUID.randomUUID().toString();// it will generate unique user id
		user.setUserid(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUser(String userId) {
		//get one user
		User user=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with given ID is not found in data"));
		
		//fetch rating of the above user from Rating Service
		//localhost:8083/ratings/users/9c4d8513-46b2-48f6-9fbc-50e575427a3a
		Ratings[] ratingsofUsers=restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserid(), Ratings[].class);
		
		//Ratings ratings=ratingService.getRating(user.getUserid());
		
		List<Ratings> ratings=Arrays.stream(ratingsofUsers).toList();
		
		List<Ratings> ratinglist=ratings.stream().map(rating->{
			//api to call the hotel Service to get the hotel
			//localhost:8082/hotels/4685b007-3968-4ee9-a4c0-acee9fa82c5e
			//ResponseEntity<Hotel> hotellist=restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelid(), Hotel.class);
			
			
			Hotel hotel=hotelServices.getHotel(rating.getHotelid());  //Feign Client Use
			
		//set the hotel to the string
			rating.setHotel(hotel);
		
		//return the rating
			return rating;
		}).collect(Collectors.toList());
		
		user.setRatings(ratinglist);
		
		return user;
	}
	
}
