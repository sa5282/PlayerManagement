package com.sa.playermanagement.dto;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sa.playermanagement.db.model.Player;
import com.sa.playermanagement.db.model.Sport;

public class PlayerDTO {
	
    private Long id;
	private String email;
	private int level;
	private int age;
	private String gender;
	private Set<SportDTO> sports = new HashSet<>();

	public PlayerDTO(Long id, String email, int level, int age, String gender, Set<SportDTO> sports) {
		super();
		this.id = id;
		this.email = email;
		this.level = level;
		this.age = age;
		this.gender = gender;
		this.sports = sports;
	}
	
	public PlayerDTO(Player player) {
		this.id = player.getId();
		this.email = player.getEmail();
		this.level = player.getLevel();
		this.age = player.getAge();
		this.gender = player.getGender();
		
		if (player.getSports() != null) {
			for (Sport s : player.getSports()) {
				SportDTO sport = new SportDTO(s.getId(), s.getName(), null);
				this.sports.add(sport);
			}
		}
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@JsonInclude(Include.NON_NULL)
	public Set<SportDTO> getSports() {
		return sports;
	}
	
	public void setSports(Set<SportDTO> sports) {
		this.sports = sports;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		PlayerDTO other = (PlayerDTO) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

}
