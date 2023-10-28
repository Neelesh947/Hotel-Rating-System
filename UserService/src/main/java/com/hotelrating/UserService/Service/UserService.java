package com.hotelrating.UserService.Service;

import java.util.List;

import com.hotelrating.UserService.Model.User;

public interface UserService {
	
	//create User
	User saveUser(User user);
	
	//get all user
	List<User> getAllUser();
	
	//get single user of given user id
	
	User getUser(String userId);
	
	//To do -> delete, update

}
