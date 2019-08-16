package com.poc.userservice.rest.controller;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.userservice.rest.pojo.UserAccount;

@RestController
@Component
public class UserController {
	
	 private static HashMap<String,UserAccount> userDB = new HashMap<String,UserAccount>();
	
	 static {
		 userDB.put("100",new UserAccount("gopal","patnaik","100"));
		 userDB.put("101",new UserAccount("gopal","patnaik","101"));
		 userDB.put("102",new UserAccount("gopal","patnaik","102"));
		 userDB.put("103",new UserAccount("gopal","patnaik","103"));
		 userDB.put("104",new UserAccount("gopal","patnaik","104"));
		 userDB.put("105",new UserAccount("gopal","patnaik","105"));
	 }

	@RequestMapping(value = "/user/{id}")
    public ResponseEntity<UserAccount> getUser(@PathVariable("id") String id)
    {
		ResponseEntity<UserAccount> response=null;
		if(userDB.containsKey(id)) {
		
		    response = new ResponseEntity(userDB.get(id), HttpStatus.OK);
		}else {
			response = new ResponseEntity(null, HttpStatus.NO_CONTENT);
		
		}
		return response;
    }
}
