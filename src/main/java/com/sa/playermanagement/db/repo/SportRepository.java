package com.sa.playermanagement.db.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sa.playermanagement.db.model.Sport;

@Repository
public interface SportRepository extends JpaRepository<Sport, Long> {

	@Query("select s from SPORT s where size(s.players) > 1")
	List<Sport> sportsWith2OrMorePlayers();
	
	@Query("select s from SPORT s where size(s.players) = 0")
	List<Sport> sportsWithZeroPlayers();
	
	Sport findByName(String name);
}
