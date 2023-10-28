package com.hotelrating.HotelService.Controller;

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

import com.hotelrating.HotelService.Model.Hotel;
import com.hotelrating.HotelService.Service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@PostMapping
	private ResponseEntity<Hotel > createHotel(@RequestBody Hotel hotel)
	{
		Hotel hotel1=hotelService.create(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
	}
	
	@GetMapping
	private ResponseEntity<List<Hotel>> findAllHotels()
	{
		List<Hotel> allhotels=hotelService.getAll();
		return ResponseEntity.ok(allhotels);
		
	}
	
	@GetMapping("/{hotelid}")
	private ResponseEntity<Hotel> getUserByID(@PathVariable String hotelid)
	{
		Hotel hotel1=hotelService.getHotelByid(hotelid);
		return ResponseEntity.ok(hotel1);
	}

}
