package com.brian.test;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//@Entity
//@Table(name="user")
public interface UserRepository extends CrudRepository<User , Integer>{
	 
	//@Query(value = "SELECT u.id, u.name, u.email,u.responseid FROM user u WHERE u.id = :id")
	public User findById(Integer id);	
 
	
	 
}
  