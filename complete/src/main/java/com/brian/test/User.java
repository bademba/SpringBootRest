package com.brian.test;


import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "User")
//@javax.persistence.Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id; 

    private String name;

    private String email;
    private String responseid;

    @Column(name = "id")
	public Integer getId() {
		
		return id;
	}

	public void setId(Integer id) {
	 
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "responseid")
	public String getResponseid() {
		UUID uuid = UUID.randomUUID();
		responseid = uuid.toString();
		return responseid;
	}

	public void setResponseid(String responseid) {
		this.responseid = responseid;
	}
    
    
}

