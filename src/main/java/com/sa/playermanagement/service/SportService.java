package com.sa.playermanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sa.playermanagement.db.model.Player;
import com.sa.playermanagement.db.model.Sport;
import com.sa.playermanagement.db.repo.PlayerRepository;
import com.sa.playermanagement.db.repo.SportRepository;
import com.sa.playermanagement.dto.PostResponseDTO;
import com.sa.playermanagement.dto.SportDTO;

@Service
public class SportService {

	@Autowired
	private SportRepository sportRepo;
	
	@Autowired
	private PlayerRepository playerRepo;
	
	public List<Sport> getSportsWith2OrMorePlayers() {
		List<Sport> sports = sportRepo.sportsWith2OrMorePlayers();
		return sports;
	}
	
	public List<Sport> getSportsWithZeroPlayers() {
		return sportRepo.sportsWithZeroPlayers();
	}
	
	public List<SportDTO> getAllSports() {
		List<SportDTO> response = new ArrayList<SportDTO>();
		
		List<Sport> sports = sportRepo.findAll();
		
		for (Sport sport : sports) {
			SportDTO sportDTO = new SportDTO(sport);
			response.add(sportDTO);
		}
		
		return response;
	}
	
	public PostResponseDTO deleteSport(String sportName) {
		PostResponseDTO response = new PostResponseDTO();
		
		if (sportName == null || sportName.strip().isEmpty()) {
			response.setRequestStatus(PostResponseDTO.FAILED);
			response.setMessage("Sport cannot be deleted because Sport name was not provided in the request");
			return response;
		}
		
		Sport sport = sportRepo.findByName(sportName);
		
		if (sport != null) {
			
			Set<Player> players = sport.getPlayers();
			
			for (Player p : players) {
				p.removeSport(sport);
				playerRepo.save(p);
			}
			
			sportRepo.delete(sport);
			
			response.setRequestStatus(PostResponseDTO.SUCCEEDED);
			response.setMessage("Sport and its associated data has been deleted successfully");
			
		} else {
			response.setRequestStatus(PostResponseDTO.FAILED);
			response.setMessage("Sport cannot be deleted because we don't have the data for the Sport specified in the request.");
			return response;
		}
		
		return response;
	}
}
