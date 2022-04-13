package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.pojos.UserPackage;


public interface UserPackageService {
	
	public void saveUserPackage(UserPackage userPackageRequest);
	
	public void deleteUserPackages(String userId);
	
	public void deletePackage(String packageId);
	
	public List<UserPackage> isAlreadySubscribed(String userId, String packageId);

}
