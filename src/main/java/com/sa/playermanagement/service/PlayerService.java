package com.sa.playermanagement.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sa.playermanagement.db.model.Player;
import com.sa.playermanagement.db.model.Sport;
import com.sa.playermanagement.db.repo.PlayerRepository;
import com.sa.playermanagement.db.repo.SportRepository;
import com.sa.playermanagement.dto.PlayerDTO;
import com.sa.playermanagement.dto.PostResponseDTO;
import com.sa.playermanagement.dto.SportDTO;

import antlr.StringUtils;

@Service
public class PlayerService {
	
	@Autowired
	private PlayerRepository playerRepo;
	
	@Autowired
	private SportRepository sportRepo;
	
	public List<Player> findByGenderLevelAndAge(String gender, int level, int age) {
		
		return playerRepo.findByGenderAndLevelAndAge(gender, level, age);
	}
	
	public List<PlayerDTO> findAll() {
		
		List<Player> players = playerRepo.findAll();
		
		return convertToDto(players);
	}
	
	public List<PlayerDTO> findPlayerWithNoSport() {
		
		List<Player> players = playerRepo.findPlayerWithNoSport();
		
		return convertToDto(players);
	}
	
	@Transactional
	public PostResponseDTO updatePlayerSport(PlayerDTO playerDTO) {
		PostResponseDTO response = new PostResponseDTO();
		
		Player player = null;
		
		if (playerDTO.getEmail() != null) {
			player = playerRepo.findByEmail(playerDTO.getEmail().strip());
		} else if (playerDTO.getId() > 0) {
			
			Optional<Player> optional = playerRepo.findById(playerDTO.getId());
			if (optional.isPresent()) {
				player = optional.get();
			}
			
		} else {
			response.setRequestStatus(PostResponseDTO.FAILED);
			response.setMessage("Sports cannot be updated for the player, please include either the Player's email address or the Player's unique ID in the request.");
			return response;
		}
		
		if (player != null) {
			
			player.getSports().clear();
			
			// Convert each Sport DTO to Sport Entity
			for (SportDTO dto : playerDTO.getSports()) {
				
				Sport sport = sportRepo.findByName(dto.getName());
				
				if (sport == null && dto.getId() != null) {
					
					Optional<Sport> opt = sportRepo.findById(dto.getId());
					
					if (opt.isPresent()) {
						sport = opt.get();
					} else {
						response.setRequestStatus(PostResponseDTO.FAILED);
						response.setMessage("Sports cannot be updated because the system couldn't find a sport matching with the supplied name and/or sport id");
						return response;
					}
				}
				
				player.addSport(sport);
			}
			
			if (playerRepo.save(player) != null) {
				response.setRequestStatus(PostResponseDTO.SUCCEEDED);
				response.setMessage("OK");
			} else {
				response.setRequestStatus(PostResponseDTO.FAILED);
				response.setMessage("Sports cannot be updated due to an internal system error");
			}
		} else {
			response.setRequestStatus(PostResponseDTO.FAILED);
			response.setMessage("Sports cannot be updated because a matching Player was not found in the database");
		}

		return response;
	}
	
	public List<PlayerDTO> listPlayers(String sportFilter, int page, int size) {
		
		Pageable pageable = PageRequest.of(page, size);
		Page<Player> playersPage;
		
		if (sportFilter == null || sportFilter.equalsIgnoreCase("all")) {
			playersPage = playerRepo.findAll(pageable);
		} else {
			playersPage = playerRepo.findPlayersBySportFilter(sportFilter, pageable);
		}

		List<PlayerDTO> players = convertToDto(playersPage.getContent());

		return players;
		
	}

	public List<PlayerDTO> convertToDto(List<Player> players) {
		List<PlayerDTO> response = new ArrayList<>();
		
		for (Player p : players) {
			PlayerDTO dto = new PlayerDTO(p);
			response.add(dto);
		}
		
		return response;
	}
}
