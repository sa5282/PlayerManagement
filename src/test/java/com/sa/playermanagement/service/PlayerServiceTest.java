package com.sa.playermanagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sa.playermanagement.db.model.Player;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PlayerServiceTest {
	
	@Autowired
	private PlayerService playerService;

	@Test
	public void test1_findByGendercodeLevelAndAge() {
		
		List<Player> players = playerService.findByGenderLevelAndAge("M", 9, 25);

		assertEquals(players.size(), 2);
	}
	
	@Test
	public void test2_findByGendercodeLevelAndAge() {
		
		List<Player> players = playerService.findByGenderLevelAndAge("F", 10, 31);
		System.out.println("Test 2 player size : " + players.size());

		assertEquals(players.size(), 1);
	}
	
}
