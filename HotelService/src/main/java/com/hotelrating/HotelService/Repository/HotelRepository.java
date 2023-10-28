package com.hotelrating.HotelService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelrating.HotelService.Model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, String>{

}
