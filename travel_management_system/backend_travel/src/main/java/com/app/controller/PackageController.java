package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.domain.DeletePackage;
import com.app.pojos.Package;
import com.app.service.PackageService;

@RestController
@RequestMapping("/package")
@CrossOrigin
public class PackageController {
	
	@Autowired
	private PackageService packageService;

	@PostMapping("/savepackage")
	public void savePackageInfo(@RequestBody Package packageRequest) {
		packageService.savePackage(packageRequest);
	}
	
	@GetMapping("/getUserPackages")
	public List<Package> getAllUserPackages(String userId){
		return packageService.getUserSpecificPackages(userId);
	}
	
	@GetMapping
	public List<Package> getAllPackages(){
		return packageService.getAllPackages();
	}
	
	@PostMapping("/deletepackage")
	public void deletePackage(@RequestBody DeletePackage pkg) {
		packageService.deletePackage(pkg.getPackageId());
	}
}
