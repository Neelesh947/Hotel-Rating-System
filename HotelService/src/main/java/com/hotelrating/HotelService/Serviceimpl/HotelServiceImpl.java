package com.hotelrating.HotelService.Serviceimpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelrating.HotelService.Exception.ResourceNotFoundException;
import com.hotelrating.HotelService.Model.Hotel;
import com.hotelrating.HotelService.Repository.HotelRepository;
import com.hotelrating.HotelService.Service.HotelService;


@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel create(Hotel hotel) {
		String randomuid=UUID.randomUUID().toString();
		hotel.setHotelid(randomuid);		
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotelByid(String id) {
		
		return hotelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Hotel With given id not found"));
	}
	
}
