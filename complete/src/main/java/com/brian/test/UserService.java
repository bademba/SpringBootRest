package com.brian.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void updateUser(int id, User user) {
		userRepository.save(user);
	}

	public void userExist(int id, User user) {
		userRepository.exists(id);
	}
	
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}
	
	public Iterable<User> listUsers(){
		 return userRepository.findAll();
	}
	
	public User findById(Integer id) {
		return userRepository.findById(id);
	}
}
