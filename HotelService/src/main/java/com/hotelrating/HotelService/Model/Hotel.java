package com.hotelrating.HotelService.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Hotels")
public class Hotel {

	
	@Id
	private String hotelid;
	private String name;
	private String location;
	private String about;
	private String owner;
	
}
