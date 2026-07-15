package com.basket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basket.dto.LoginRequest;
import com.basket.dto.SignupRequest;
import com.basket.entity.UserEntity;
import com.basket.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	// User SignUp
	public String signup(SignupRequest request)
	{
		
		UserEntity existingUser =
	            userRepository.findByEmail(request.getEmail());

	    if (existingUser != null) {
	        return "Email already exists";
	    }
		
		UserEntity user = new UserEntity();
		
		user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setMobile(request.getMobile());
        user.setPassword(request.getPassword());
        user.setRole("CUSTOMER");

        userRepository.save(user);

        return "Signup Successful";

	}
	
	// User Login
	public String login(LoginRequest request)
	{
		UserEntity user = userRepository.findByEmail(request.getEmail());
		
		 if (user == null) {
		        return "User not found";
		    }

		    if (!user.getPassword().equals(request.getPassword())) {
		        return "Invalid Password";
		    }

		    return "Login Successful";
		}
	}

