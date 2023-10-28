package com.hotelrating.HotelService.Exception;

public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException (String s)
	{
		super();
	}
	
	public ResourceNotFoundException()
	{
		super("resource not found");
	}
}
