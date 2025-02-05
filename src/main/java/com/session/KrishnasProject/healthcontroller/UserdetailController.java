package com.session.KrishnasProject.healthcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.session.KrishnasProject.commonservices.UserService;
import com.session.KrishnasProject.entities.User;

@RestController
public class UserdetailController {
	@Autowired
	private UserService userservice;
	
	@PostMapping("/user")
	public User addUserDetails(@RequestBody User user)
	{
		return userservice.craeteUser(user);
		
		
	}

}
