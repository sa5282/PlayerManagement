package com.sa.playermanagement.dto;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sa.playermanagement.db.model.Player;
import com.sa.playermanagement.db.model.Sport;

public class SportDTO {
	
    private Long id;
    private String name;
    private Set<PlayerDTO> players = new HashSet<>();
    
	public SportDTO(Long id, String name, Set<PlayerDTO> players) {
		super();
		this.id = id;
		this.name = name;
		this.players = players;
	}
	
	public SportDTO(Sport sport) {

		this.id = sport.getId();
		this.name = sport.getName();

		if (sport.getPlayers() != null) {
			for (Player p : sport.getPlayers()) {
				PlayerDTO player = new PlayerDTO(p.getId(), p.getEmail(), p.getLevel(), p.getAge(), p.getGender(), null);
				this.players.add(player);
			}
		}
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonInclude(Include.NON_NULL)
	public Set<PlayerDTO> getPlayers() {
		return players;
	}
	public void setPlayers(Set<PlayerDTO> players) {
		this.players = players;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SportDTO other = (SportDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
    
    

}
