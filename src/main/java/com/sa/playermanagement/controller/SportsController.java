package com.sa.playermanagement.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sa.playermanagement.db.model.Sport;
import com.sa.playermanagement.dto.GetResponseDTO;
import com.sa.playermanagement.dto.PostResponseDTO;
import com.sa.playermanagement.dto.SportDTO;
import com.sa.playermanagement.service.SportService;

@RestController
@RequestMapping(path = "/api/v1/psmanager/sport")
public class SportsController {
	
	private static Logger logger = LoggerFactory.getLogger(SportsController.class);

	@Autowired
	private SportService sportService;
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<?> getSportByNames(@RequestParam(name = "names") List<String> names) {
		ResponseEntity response = null;
		
		try {
			
			if (names == null || names.isEmpty()) {
				
				//BAD Request
				GetResponseDTO dto = new GetResponseDTO();
				dto.setRequestStatus(GetResponseDTO.FAILED);
				dto.setMessage("No Sport Name was specified in the HTTP GET request, atleast one sport name must be provided for the request to be processed successfully");
				response = new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
				return response;
			}
			
			List<SportDTO> sports = sportService.getSportByNames(names);
			response = new ResponseEntity<>(sports, HttpStatus.OK);
			
		} catch (Exception ex) {
			logger.error("Exception in getSportByNames, message: " + ex.getMessage(), ex);
			
			// INTERNAL SERVER ERROR
			GetResponseDTO dto = new GetResponseDTO();
			dto.setRequestStatus(GetResponseDTO.FAILED);
			dto.setMessage("Server encountered an internal error while processing this request");
			response = new ResponseEntity<>(dto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}
	
	@GetMapping(path = "/all", produces = "application/json")
	public ResponseEntity<?> getAllSports() {
		ResponseEntity response = null;
		try {
			List<SportDTO> sports = sportService.getAllSports();
			response = new ResponseEntity<>(sports, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error("Exception in getAllSports, message: " + ex.getMessage(), ex);
			
			GetResponseDTO dto = new GetResponseDTO();
			dto.setRequestStatus(GetResponseDTO.FAILED);
			dto.setMessage("Server encountered an internal error while processing this request");
			response = new ResponseEntity<>(dto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}
	
	@PostMapping(path = "/delete/{sportName}", produces = "application/json")
	public ResponseEntity<PostResponseDTO> deleteSport(@PathVariable(required = true, name = "sportName") String sportName ) {
		ResponseEntity<PostResponseDTO> response = null;
		
		try {
			PostResponseDTO dto = sportService.deleteSport(sportName);
			response = new ResponseEntity<>(dto, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error("Exception in deleteSport(), message: " + ex.getMessage(), ex);
			
			PostResponseDTO dto = new PostResponseDTO();
			dto.setRequestStatus(GetResponseDTO.FAILED);
			dto.setMessage("Server encountered an internal error while processing this request");
			response = new ResponseEntity<>(dto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}
}
