package com.basket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basket.dto.LoginRequest;
import com.basket.dto.SignupRequest;
import com.basket.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/signup")
	public String signup(@RequestBody SignupRequest request)
	{
		String response = userService.signup(request);
		return response;
	}

	@PostMapping("/login")
	public String login(@RequestBody LoginRequest request)
	{
		String response = userService.login(request);
		return response;
	}

}
