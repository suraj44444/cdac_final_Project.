package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.domain.ResponseSuccess;
import com.app.domain.UserPackageRequest;
import com.app.pojos.UserPackage;
import com.app.service.UserPackageService;

@RestController
@RequestMapping("/userpackage")
@CrossOrigin
public class UserPackageController {

	@Autowired
	private UserPackageService userPackageService;

	@PostMapping("/saveuserpackage")
	public ResponseSuccess saveUserPackage(@RequestBody UserPackageRequest userPackageRequest) {
		List<UserPackage> userPackageList = userPackageService.isAlreadySubscribed(userPackageRequest.getUserId(),
				userPackageRequest.getPackageId());
		if (!userPackageList.isEmpty()) {
			ResponseSuccess response = new ResponseSuccess();
			response.setSuccess(false);
			return response;
		}
		UserPackage userPackage = new UserPackage();
		userPackage.setUserId(userPackageRequest.getUserId());
		userPackage.setPackageId(userPackageRequest.getPackageId());
		userPackageService.saveUserPackage(userPackage);
		ResponseSuccess response = new ResponseSuccess();
		response.setSuccess(true);
		return response;
	}

	@PostMapping("/deletepackage")
	public void deleteUserPackage(@RequestParam String packageId) {
		userPackageService.deletePackage(packageId);
	}

	@PostMapping("/deleteuserpackage")
	public void deleteUser(@RequestParam String userId) {
		userPackageService.deleteUserPackages(userId);
	}

}
