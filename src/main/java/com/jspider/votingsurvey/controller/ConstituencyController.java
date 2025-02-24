package com.jspider.votingsurvey.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.jspider.votingsurvey.entity.Constituency;
import com.jspider.votingsurvey.services.ConstituencysService;

@RestController
@RequestMapping(value = "/api/constituency")
@CrossOrigin(value = "http://localhost:5173")
public class ConstituencyController {

	@Autowired
	private ConstituencysService service;
	
	@PostMapping
	public Constituency saveConstituency(@RequestBody Constituency constituency) {
		Optional<Constituency> optional = service.getConstituencyById(constituency.getId());
		if (optional.isPresent()) {
			return null;
		}else
			return service.saveConstituency(constituency);
	}
	
	@PostMapping("/all")
	public List<Constituency> saveMultipleConstituencyController(@RequestBody List<Constituency> constituencyList) {
	    List<Constituency> savedConstituencies = new ArrayList<>();

	    for (Constituency constituency : constituencyList) {
	        if (constituency.getId() != null && service.getConstituencyById(constituency.getId()).isPresent()) {
	            continue; // Skip if ID is already present
	        }
	        savedConstituencies.add(service.saveConstituency(constituency));
	    }

	    return savedConstituencies;
	}

	
	@GetMapping
	List<Constituency> getAllConstituencyController(){
		return service.getAllConstituency();
	}
	
	@GetMapping(value = "/{id}")
	Optional<Constituency> getConstituencyByIdController(@PathVariable(name = "id") Long id){
		return service.getConstituencyById(id);
	}
	
	@GetMapping(value = "/name/{name}")
	Optional<Constituency> getConstituencyByName(@PathVariable(name = "name") String name){
		return service.getConstituencyByName(name);
	}
	
	@GetMapping("/active")
    public List<Constituency> getActiveConstituenciesController() {
		return service.getActiveConstituencies();
	}
	
	@GetMapping("/state/{state}")
    public List<Constituency> getConstituenciesByStateController(@PathVariable String state) {
		return service.getConstituenciesByState(state);
	}
	
	@GetMapping("/allConstituencyByIdOrName")
	public ResponseEntity<?> getConstituenciesByNameOrIdController(
	        @RequestParam(required = false) Long id,
	        @RequestParam(required = false) String name) {

	    if (id == null && name == null) {
	        return ResponseEntity.badRequest().body(Collections.singletonMap("error", "Either 'id' or 'name' is required"));
	    }

	    List<Constituency> constituencies = service.getConstituencyByIdOrName(id, name);
	    return ResponseEntity.ok(constituencies);
	}
	
	
	@PutMapping("/{id}/election-status/{electionActive}")
	public Constituency updateElectionStatusController(@PathVariable Long id, @PathVariable boolean electionActive) {
		return service.updateElectionStatus(id, electionActive);
	}
	
}

