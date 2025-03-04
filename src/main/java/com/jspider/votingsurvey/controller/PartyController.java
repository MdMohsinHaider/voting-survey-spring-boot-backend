package com.jspider.votingsurvey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.jspider.votingsurvey.entity.Party;
import com.jspider.votingsurvey.services.PartysService;

@RestController
@RequestMapping(value = "/api/party")
@CrossOrigin(value = "http://localhost:5173")
public class PartyController {
	
	@Autowired
	private PartysService service;
	
	@PostMapping
	public Party savePartyController(@RequestBody Party party) {
	    return service.saveParty(party);
	}
	
	@GetMapping
	public List<Party> getAllPartyscontroller() {
		return service.getAllPartys();
	}
	
	@GetMapping(value = "/constituency-number/{constituencyId}")
	public List<Party> getPartiesByConstituency(@PathVariable Long constituencyId){
		return service.getPartiesByConstituency(constituencyId);
	}
	
	@GetMapping(value = "/activeConstituenciePartys")
	public List<Party> getAllPartysByActiveConstituenciesNumberController() {
		return service.getAllPartysByActiveConstituenciesNumber();
	}
	
	
	@GetMapping(value = "/allActiveElectionParties")
	public List<Party> getActiveElectionPartiesController(){
		return service.getActiveElectionParties();
	}
	
	@DeleteMapping(value = "/delete/{Id}")
	boolean deletePartyByIdDao(@PathVariable Long Id) {
		return service.deletePartyByIdDao(Id);
	}
	
	
	@PutMapping("/{partyId}/votes")
    public ResponseEntity<String> updatePartyVotes(@PathVariable Long partyId, @RequestParam Long votes) {
        boolean isUpdated = service.updateVotes(partyId, votes);
        if (isUpdated) {
            return ResponseEntity.ok("Votes updated successfully.");
        } else {
            return ResponseEntity.badRequest().body("Failed to update votes.");
        }
	}
	
	@GetMapping("/byConstituencyIdOrName")
    public List<Party> getPartiesByConstituencyIdOrNameController(@RequestParam(required = false) Long constituencyId,
                                  @RequestParam(required = false) String constituencyName) {
        return service.getPartiesByConstituencyIdOrName(constituencyId, constituencyName);
	}
	
	@PutMapping("/resetVotes")
    public ResponseEntity<String> resetVotesByConstituencyId(@RequestParam Long constituencyId) {
        String responseMessage = service.resetAllPartyVotesByConstituencyId(constituencyId);
        return ResponseEntity.ok(responseMessage);
    }
	
	
}
