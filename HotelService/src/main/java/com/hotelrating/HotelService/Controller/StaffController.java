package com.hotelrating.HotelService.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staffs")
public class StaffController {
	

	@GetMapping
	public ResponseEntity<List<String>> getStaff()
	{
		List<String> staff= Arrays.asList("Rahul","Ritesh","Gyan","Ashish");
		return new ResponseEntity<>(staff, HttpStatus.OK);
	}
}
