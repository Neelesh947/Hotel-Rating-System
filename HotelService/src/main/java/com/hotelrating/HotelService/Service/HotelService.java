package com.hotelrating.HotelService.Service;

import java.util.List;

import com.hotelrating.HotelService.Model.Hotel;

public interface HotelService {

	//create hotels
	Hotel create(Hotel hotel); 
	
	
	
	//List of all the hotels
	List<Hotel> getAll();
	
	
	//List of hotel by hotel IDs
	Hotel getHotelByid(String id);
	
	
}
