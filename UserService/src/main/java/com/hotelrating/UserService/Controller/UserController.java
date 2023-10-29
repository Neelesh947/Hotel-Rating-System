package com.hotelrating.UserService.Controller;

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

import com.hotelrating.UserService.Model.User;
import com.hotelrating.UserService.Service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//create	
	@PostMapping()
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		User user1= userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	
	//find all user
	@GetMapping
	public ResponseEntity<List<User>> getAllUser()
	{
		List<User> alluser=userService.getAllUser();
		return ResponseEntity.ok(alluser);
	}
	
	//find single user
	
	int retryCount=1;
	
	@GetMapping("/{userid}")
	//@CircuitBreaker(name="ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
	@Retry(name="ratingHotelService",fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<User> getSingleUser(@PathVariable String userid)
	{
		log.info("get Single user Handler: UserController");
		log.info("Retry Count: {}",retryCount);
		retryCount++;
		
		User user1=userService.getUser(userid);
		return ResponseEntity.ok(user1);
	}
	
	
	// create ratingHotelFallback method for circuit breaker
	public ResponseEntity<User> ratingHotelFallback(String userid, Exception ex)
	{
		
		User user=User.builder()
				.email("dummy@email.com")
				.name("dummy name")
				.about("This is created because some of the services is not down")
				.dob("dummy dob")
				.gender("false")
				.location("dummy location")
				.userid("6846846846")
				.build();
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
}
