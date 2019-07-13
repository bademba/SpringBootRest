package com.brian.test;


import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id; 

    private String name;

    private String email;
    private String responseid;

	public Integer getId() {
		
		return id;
	}

	public void setId(Integer id) {
	 
		this.id = id;
	}

	public String getName() {
		
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getResponseid() {
		UUID uuid = UUID.randomUUID();
		responseid = uuid.toString();
		return responseid;
	}

	public void setResponseid(String responseid) {
		this.responseid = responseid;
	}
    
    
}

