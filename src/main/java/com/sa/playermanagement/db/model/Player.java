package com.sa.playermanagement.db.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "PLAYER")
public class Player {
	
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(name = "EMAIL", nullable = false, length = 75, unique = true)
	private String email;
    
    @Column(name = "LEVEL", nullable = false)
	private int level;
    
    @Column(name = "AGE", nullable = false)
	private int age;
    
    @Column(name = "GENDER")
    private String gender;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GENDER", referencedColumnName = "CODE", insertable = false, updatable = false)
	private Gender genderObj;
	
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable(name = "SPORT_PLAYER", joinColumns = {@JoinColumn(name = "PLAYER_ID")}, inverseJoinColumns = {@JoinColumn(name = "SPORT_ID")} )
	private Set<Sport> sports = new HashSet<>();

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

	public Set<Sport> getSports() {
		return sports;
	}

	public void setSports(Set<Sport> sports) {
		this.sports = sports;
	}
	
	public void addSport(Sport sportToBeAdded) {
		if (!this.sports.contains(sportToBeAdded)) {
			this.sports.add(sportToBeAdded);
		}
	}
	
	public void removeSport(Sport sportToBeRemoved) {
		if (this.sports.contains(sportToBeRemoved)) {
			this.sports.remove(sportToBeRemoved);
			
		}
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
		Player other = (Player) obj;
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
