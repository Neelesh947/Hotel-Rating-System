package com.hotelrating.UserService.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hotelrating.UserService.Model.Hotel;

@FeignClient(name="HOTEL-SERVICE")
public interface HotelServices {

	@GetMapping("/hotels/{hotelid}")
	Hotel getHotel(@PathVariable String hotelid);
	
}
