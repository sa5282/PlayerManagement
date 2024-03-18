package com.sa.playermanagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sa.playermanagement.db.model.Player;

@SpringBootTest
class PlayerServiceTest {
	
	@Autowired
	private PlayerService playerService;

	@Test
	void test1_findByGendercodeLevelAndAge() {
		
		List<Player> players = playerService.findByGenderLevelAndAge("M", 9, 25);

		assertEquals(players.size(), 2);
	}
	
	@Test
	void test2_findByGendercodeLevelAndAge() {
		
		List<Player> players = playerService.findByGenderLevelAndAge("F", 10, 31);
		System.out.println("Test 2 player size : " + players.size());

		assertEquals(players.size(), 1);
	}
	
}
