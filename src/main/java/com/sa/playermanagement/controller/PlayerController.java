package com.sa.playermanagement.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sa.playermanagement.db.model.Player;
import com.sa.playermanagement.dto.GetResponseDTO;
import com.sa.playermanagement.dto.PlayerDTO;
import com.sa.playermanagement.dto.PostResponseDTO;
import com.sa.playermanagement.dto.SportDTO;
import com.sa.playermanagement.service.PlayerService;

@RestController
@RequestMapping(path = "/api/v1/psmanager/player")
public class PlayerController {
	
	private static Logger logger = LoggerFactory.getLogger(PlayerController.class);
	
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
	
	@GetMapping(path = "/list", produces = "application/json")
	public ResponseEntity<?> getPlayerList(@RequestParam(required = false) String sportFilter, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		
		ResponseEntity response = null;
		
		try {
			
			List<PlayerDTO> players = playerService.listPlayers(sportFilter, page, size);
			response = new ResponseEntity<>(players, HttpStatus.OK);
			
		} catch (Exception ex) {
			logger.error("Exception in getPlayerList, message: " + ex.getMessage(), ex);
			
			GetResponseDTO dto = new GetResponseDTO();
			dto.setRequestStatus(GetResponseDTO.FAILED);
			dto.setMessage("Server encountered an internal error while processing this request");
			response = new ResponseEntity<>(dto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}

}
