package com.jspider.votingsurvey.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspider.votingsurvey.entity.User;
import com.jspider.votingsurvey.services.UsersService;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

	@Autowired
	private UsersService service;
	
	@PostMapping(value = "/register")
	public User saveUserController(@RequestBody User user){
		return service.saveUser(user);	
	}
	
	@GetMapping
	public List<User> getAllUserController(){
		return service.getAllUsers();
	}
	
	@GetMapping(value = "/{id}")
	public Optional<User> getUserByIdController(@PathVariable int id) {
		return service.getUserById(id);
	}
	
	@GetMapping(value = "/email/{email}")
	public Optional<User> getUserByEmailController(@PathVariable(name = "email") String email){
		return service.getUserByEmail(email);
	}
	
	@GetMapping(value =  "/voterId/{vid}")
	public Optional<User> getUserByVoterId(@PathVariable Long vid) {
		return service.getUserByVoterId(vid);
	}
	
	@DeleteMapping(value = "/{id}")
	public boolean deleteUserById(@PathVariable int id) {
		return service.deleteUserById(id);
	}
	
	@PutMapping(value = "/{id}")
	public Optional<User> updateUserById(@PathVariable int id, @RequestBody User user) {
		return service.updateUserById(id, user);
	}
	
	
}


