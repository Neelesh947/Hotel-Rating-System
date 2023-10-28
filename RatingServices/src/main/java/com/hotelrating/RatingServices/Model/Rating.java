package com.hotelrating.RatingServices.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("user_ratings")
public class Rating {

	@Id
	private String ratingid;
	private String userid;
	private String hotelid;
	private int rating; 
	private String feedback;
}
