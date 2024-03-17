package com.sa.playermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sa.playermanagement.db.model.Sport;
import com.sa.playermanagement.dto.PostResponseDTO;
import com.sa.playermanagement.dto.SportDTO;
import com.sa.playermanagement.service.SportService;

@RestController
@RequestMapping(path = "/api/v1/psmanager/sport")
public class SportsController {

	@Autowired
	private SportService sportService;
	
	@GetMapping(path = "/all", produces = "application/json")
	public List<SportDTO> getAllSports() {
		
		return sportService.getAllSports();
	}
	
	@PostMapping(path = "/delete/{sportName}", produces = "application/json")
	public PostResponseDTO deleteSport(@PathVariable(required = true, name = "sportName") String sportName ) {
		
		return sportService.deleteSport(sportName);
	}
}
