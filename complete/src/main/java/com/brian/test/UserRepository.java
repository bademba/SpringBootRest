package com.brian.test;

import org.springframework.data.repository.CrudRepository;
 
public interface UserRepository extends CrudRepository<User , Integer>{
 
	public User findById(Integer id);	
 
	public User deleteById(Integer id);
	
	public Iterable<User> findAll();
	
	 
}
  