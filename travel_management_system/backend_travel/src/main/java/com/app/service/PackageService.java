package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.pojos.Package;

public interface PackageService {

	  public void savePackage(Package packageRequest);
	  
	  public List<Package> getAllPackages();
	  
	  public List<Package> getUserSpecificPackages(String userId);
	  
	  public void deletePackage(String packageId);
	  
}
