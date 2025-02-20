package com.jspider.votingsurvey.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		System.out.println(constituency);
		return service.saveConstituency(constituency);
	}
	
	@PostMapping(value = "/all")
	public List<Constituency> saveMultipleConstituencyController(@RequestBody List<Constituency> constituencyList) {
		return service.saveMultipleConstituency(constituencyList);
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
}

