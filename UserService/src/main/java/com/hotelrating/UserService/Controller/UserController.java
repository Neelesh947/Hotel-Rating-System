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

@RestController
@RequestMapping("/users")
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
	@GetMapping("/{userid}")
	public ResponseEntity<User> getSingleUser(@PathVariable String userid)
	{
		User user1=userService.getUser(userid);
		return ResponseEntity.ok(user1);
	}
}
