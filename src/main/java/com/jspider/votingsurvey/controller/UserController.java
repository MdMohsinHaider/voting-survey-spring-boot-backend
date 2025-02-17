package com.jspider.votingsurvey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jspider.votingsurvey.entity.User;
import com.jspider.votingsurvey.services.UsersService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UsersService service;
	
	@PostMapping
	public User saveUserController(@RequestBody User user){
		return service.saveUser(user);	
	}
}

