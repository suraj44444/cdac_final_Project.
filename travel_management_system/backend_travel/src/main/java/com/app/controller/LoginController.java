package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.domain.Login;
import com.app.domain.ValidUser;
import com.app.pojos.User;
import com.app.service.UserService;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins= "http://localhost:3000")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/getLogin")
	public ValidUser getLoginSuccess(@RequestBody Login login ) {
		Optional<User> user = userService.getUserByUsernameAndPassword(login.getUsername(), login.getPassword());
		if(user.isPresent()) {
			return ValidUser.returnValidUser(user.get());
		} else {
			return ValidUser.returnNotValidUser();
		}
		
	}
	
	@PostMapping("/saveUser")
	public ValidUser saveUser(@RequestBody User user ) {
		
		if(userService.getUserIfAlreadyPresent(user.getUsername()).isPresent()) {
			return ValidUser.returnNotValidUser();
		}
		userService.saveUser(user);
		return ValidUser.returnValidUser(user);
	}
	
	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

}
