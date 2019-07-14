package com.brian.response;

import java.util.UUID;

import org.springframework.web.bind.annotation.ResponseBody;

import com.brian.test.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ResponseService {

	Responses response = new Responses();
	ObjectMapper mapper = new ObjectMapper();
	UUID uuid = UUID.randomUUID();
	User user = new User();

	@ResponseBody
	public String successResponse() {
		response.responseId = uuid.toString();
		response.responseStatus = 0;
		response.responseCode = 200;
		response.responseDesc = "Success";
		String jsonResponse = "";
		try {
			jsonResponse = mapper.writeValueAsString(response);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonResponse;
	}

	public String updateSuccess() {
		response.responseId = uuid.toString();
		response.responseStatus = 0;
		response.responseCode = 200;
		response.responseDesc = "User updated Successfully";
		String jsonResponse = "";
		try {
			jsonResponse = mapper.writeValueAsString(response);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonResponse;
	}

	public String deleteSuccess() {
		response.responseId = uuid.toString();
		response.responseStatus = 0;
		response.responseCode = 200;
		response.responseDesc = "User deleted Successfully";
		String jsonResponse = "";
		try {
			jsonResponse = mapper.writeValueAsString(response);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonResponse;
	}
	
	@ResponseBody
	public String  userNotFound() {
		response.responseId = uuid.toString();
		response.responseStatus = 0;
		response.responseCode = 200;
		response.responseDesc = "User not found";
		String jsonResponse="";
		try {
			jsonResponse = mapper.writeValueAsString(response);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonResponse;
	 
	}
}
