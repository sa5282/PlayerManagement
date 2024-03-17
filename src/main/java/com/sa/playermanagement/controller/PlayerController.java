package com.sa.playermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sa.playermanagement.dto.PlayerDTO;
import com.sa.playermanagement.dto.PostResponseDTO;
import com.sa.playermanagement.dto.SportDTO;
import com.sa.playermanagement.service.PlayerService;

@RestController
@RequestMapping(path = "/api/v1/psmanager/player")
public class PlayerController {
	
	@Autowired
	private PlayerService playerService;

	@GetMapping(path = "/all", produces = "application/json")
	public List<PlayerDTO> getAllPlayers() {
		
		return playerService.findAll();
	}
	
	@GetMapping(path = "/no-sport", produces = "application/json")
	public List<PlayerDTO> getPlayersWithNoSport() {
		
		return playerService.findPlayerWithNoSport();
	}
	
	/*
	 * This could be enhanced to handle a list of Players instead of accepting one player at a time
	 */
	@PostMapping(path = "/update-sports", consumes = "application/json")
	public PostResponseDTO updatePlayerSport(@RequestBody(required = true) PlayerDTO player) {
		
		return playerService.updatePlayerSport(player);
	}
}
