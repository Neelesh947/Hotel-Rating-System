package com.hotelrating.UserService.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

	private String hotelid;
	private String name;
	private String location;
	private String about;
	private String owner;
}
