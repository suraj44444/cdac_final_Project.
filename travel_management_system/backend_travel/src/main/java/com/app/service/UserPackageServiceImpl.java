package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.UserPackage;
import com.app.dao.UserPackageRepository;
import com.app.service.UserPackageService;

@Service
@Transactional
public class UserPackageServiceImpl implements UserPackageService {

	@Autowired
	private UserPackageRepository uprepo;

	@Override
	public void saveUserPackage(UserPackage userPackageRequest) {
		uprepo.save(userPackageRequest);
	}

	@Override
	public void deleteUserPackages(String userId) {
		uprepo.deleteAllByUserId(userId);
	}

	@Override
	public void deletePackage(String packageId) {
		uprepo.deleteAllByUserId(packageId);
	}

	@Override
	public List<UserPackage> isAlreadySubscribed(String userId, String packageId) {
		return uprepo.findAllRecordsByUserIdAndPackageId(userId, packageId);
	}

}
