package com.sa.playermanagement.db.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sa.playermanagement.db.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

	List<Player> findByGenderAndLevelAndAge(String gender, int level, int age);
	
	@Query("select p from PLAYER p where size(p.sports) = 0")
	List<Player> findPlayerWithNoSport();
	
	Player findByEmail(String email);
	
	@Query("select p from PLAYER p join p.sports sports where sports.name = :sportName")
	Page<Player> findPlayersBySportFilter(String sportName, Pageable pageable);
}
