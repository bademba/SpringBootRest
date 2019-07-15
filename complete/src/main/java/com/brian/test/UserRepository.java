package com.brian.test;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface UserRepository extends CrudRepository<User , Integer>{
 
	public User findById(Integer id);	
 
	public User deleteById(Integer id);
	
	public Iterable<User> findAll();
	
	@Query("select name, email, responseid from User where email like %?1")
	public User findByEmail(String email);
	
	 
}
  