package com.sa.playermanagement.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Gender {

    @Id
    private String code;
    
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;
}