package com.hotelrating.UserService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelrating.UserService.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>
{

}
