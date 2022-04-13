package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.pojos.User;


public interface UserService {
	
	public List<User> getAllUsers();
	
	public Optional<User> getUser(String id);
	
	public Optional<User> getUserIfAlreadyPresent(String username);
	
	public void saveUser(User user);
	
	public Optional<User> getUserByUsernameAndPassword(String username,String password);
	
}
