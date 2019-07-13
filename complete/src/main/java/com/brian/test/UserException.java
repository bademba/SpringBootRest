package com.brian.test;

import com.brian.response.ResponseService;

public class UserException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Raises a fault when user is not found
	public String UserNotFoundException() {
	     ResponseService responseService =  new ResponseService();
	     
		return responseService.userNotFound();
	  } 
}
