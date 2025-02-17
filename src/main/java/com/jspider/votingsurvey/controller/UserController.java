package com.jspider.votingsurvey.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jspider.votingsurvey.entity.User;
import com.jspider.votingsurvey.services.UsersService;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

	@Autowired
	private UsersService service;
	
	@PostMapping
	public User saveUserController(@RequestBody User user){
		return service.saveUser(user);	
	}
	
	@GetMapping
	public List<User> getAllUserController(){
		return service.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public Optional<User> getUserByIdController(@PathVariable(name = "id") int id) {
		return service.getUserById(id);
	}
	
}

