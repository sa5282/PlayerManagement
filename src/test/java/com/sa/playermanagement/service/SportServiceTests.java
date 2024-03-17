package com.sa.playermanagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sa.playermanagement.db.model.Sport;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SportServiceTests {

	@Autowired
	private SportService sportService;
	
	@Test
	public void test1_getSportsWith2OrMorePlayers() {
		List<Sport> sports = sportService.getSportsWith2OrMorePlayers();
		
//		for (Sport sport : sports) {
//			System.out.println("Sport Name : " + sport.getName());
//		}
		
		assertEquals(sports.size(), 7l);
	}
	
	@Test
	public void test2_getSportsWithZeroPlayers() {
		List<Sport> sports = sportService.getSportsWithZeroPlayers();
		
//		for (Sport sport : sports) {
//			System.out.println("Sport Name : " + sport.getName());
//		}
		
		assertEquals(sports.size(), 1l);
		assertEquals(sports.get(0).getName(), "Golf");
	}
}
