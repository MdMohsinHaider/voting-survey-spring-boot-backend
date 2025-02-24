package com.jspider.votingsurvey.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.jspider.votingsurvey.entity.User;
import com.jspider.votingsurvey.services.UsersService;

@RestController
@RequestMapping(value = "/api/user")
@CrossOrigin(value = "http://localhost:5173")
public class UserController {

	@Autowired
	private UsersService service;
	
	@PostMapping(value = "/register")
	public ResponseEntity<?> saveUserController(@RequestBody User user) {
	    if (user.getAge() < 18) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You must be at least 18 years old to register.");
	    }

	    long vid = user.getVoterId();
	    Optional<User> optional = service.getUserByVoterId(vid);

	    if (optional.isPresent()) {
	        return ResponseEntity.status(HttpStatus.CONFLICT).body("Voter ID already exists. Please use a different Voter ID.");
	    }

	    User savedUser = service.saveUser(user);
	    return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
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
	
	@GetMapping("/constituency/{constituency}")
    public List<User> getUsersByConstituencyController(@PathVariable String constituency) {
		return service.getUsersByConstituency(constituency);
	}
	
	@DeleteMapping(value = "/{id}")
	public boolean deleteUserById(@PathVariable int id) {
		return service.deleteUserById(id);
	}
	
	@PutMapping(value = "/{id}")
	public Optional<User> updateUserById(@PathVariable int id, @RequestBody User user) {
		return service.updateUserById(id, user);
	}
	
	@PostMapping(value = "/login")
	public boolean loginUserByVoterIdAndPassword(@RequestBody Map<String, Object> loginRequest) {
	    Long voterId = Long.valueOf(loginRequest.get("voterId").toString());
	    String password = loginRequest.get("password").toString();

	    System.out.println("From Controller: Voter ID = " + voterId + ", Password = " + password);
	    return service.loginUserByVoterIdAndPassword(voterId, password);
	}

	
	@PutMapping(value = "/constituency/{constituency}/vote-status/{hasVoted}")
    public List<User> updateVotingStatus(@PathVariable String constituency, @PathVariable boolean hasVoted) {
		return service.updateVotingStatus(constituency, hasVoted);
	}
	
	@PutMapping(value = "/voterId/{vid}/vote-status/{hasVoted}")
	public User updateVotingStatusByUserVoterIdController(@PathVariable Long vid, @PathVariable boolean hasVoted) {
		return service.updateVotingStatusByUserVoterId(vid, hasVoted);
	}
	
//	@PutMapping("/reset-votes/{constituencyNumber}")
//    public ResponseEntity<String> resetVotes(@PathVariable Long constituencyNumber) {
//        boolean isUpdated = service.resetVotesByConstituency(constituencyNumber);
//        if (isUpdated) {
//            return ResponseEntity.ok("Votes reset successfully for constituency: " + constituencyNumber);
//        } else {
//            return ResponseEntity.badRequest().body("No users found with hasVoted=true in constituency: " + constituencyNumber);
//        }
//    }
	
	@PutMapping("/reset-votes/{constituencyNumber}")
	public boolean resetVotesByConstituency(@PathVariable Long constituencyNumber) {
		return service.resetVotesByConstituency(constituencyNumber);
	}
}


