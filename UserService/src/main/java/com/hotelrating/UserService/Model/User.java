package com.hotelrating.UserService.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="user")
public class User {

	@Id
	private String userid;
	private String name;
	private String email;
	private String about;
	private String gender;
	private String dob;
	private String location;
	
	@Transient
	private List<Ratings> ratings=new ArrayList<>();
}
