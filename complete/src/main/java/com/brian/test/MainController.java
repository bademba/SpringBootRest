package com.brian.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.UUID;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.LoggerFactory;
import com.brian.response.ResponseService;
import com.brian.response.Responses;
import com.brian.test.User;
import com.brian.test.UserRepository;

@RestController
@Controller  
@RequestMapping(path = "/demo")  
public class MainController {
	@Autowired  
				 
	private UserRepository userRepository;
	ObjectMapper mapper = new ObjectMapper();
	UUID id = UUID.randomUUID();
	ResponseService responseService = new ResponseService();
	Responses responses = new Responses();
	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(MainController.class);

	@RequestMapping(method = RequestMethod.POST, value = "/newuser")
	public @ResponseBody String addNewUser(@RequestBody User user)
			throws JsonGenerationException, JsonMappingException, IOException {
		user.setId(user.getId());
		user.setName(user.getName());
		user.setEmail(user.getEmail());
		user.setResponseid(user.getResponseid());
		userRepository.save(user);
		LOG.info("New user created " + user.getName());
		return responseService.successResponse();
	}

	@PutMapping("/updateuser/{id}")
	public @ResponseBody User updateUser(@RequestBody User user, @PathVariable Integer id)
			throws JsonGenerationException, JsonMappingException, IOException {

		User usr = userRepository.findById(id);
		try {
			usr.setName(user.getName());
			usr.setEmail(user.getEmail());			 
			return userRepository.save(usr);
		}
		catch (UserException ex) {
			return user;
		}
	}

	@DeleteMapping("/deleteuser/{id}")
	public  void deleteUser(@PathVariable  Integer id) {
	 userRepository.delete(id);
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping(path = "/user/{id}")
	public  User  getUser(@PathVariable Integer id) {
		User user =  userRepository.findById(id);
		user.getEmail();
		user.getName();
		user.getResponseid();
		LOG.info("|id="+user.getId() +" |name="+user.getName() +  " |ëmail="+user.getEmail()+" |responseId="+user.getResponseid());
		return user;
		} 
	
	@GetMapping(path = "/finduser/{email}")
	public  User  findByEmail(@PathVariable String email) {
		return  userRepository.findByEmail(email);
	 
		 
		} 
}
