package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.Package;
import com.app.pojos.UserPackage;
import com.app.dao.PackageRepository;
import com.app.dao.UserPackageRepository;
import com.app.service.PackageService;
import com.app.service.UserPackageService;

@Service
@Transactional
public class PackageServiceImpl implements PackageService {

	@Autowired
	private PackageRepository packageRepo;

	@Autowired
	private UserPackageRepository userPackageRepo;

	@Autowired
	private UserPackageService userPackageService;

	@Override
	public void savePackage(Package packageRequest) {
		packageRepo.save(packageRequest);
	}

	@Override
	public List<Package> getAllPackages() {
		return packageRepo.findAll();
	}

	@Override
	public List<Package> getUserSpecificPackages(String userId) {
		List<UserPackage> userPackages = userPackageRepo.findAllRecordsByUserId(userId);
		List<Package> packages = new ArrayList<>();
		for (UserPackage userPackage : userPackages) {
			Optional<Package> packageRes = packageRepo.findById(userPackage.getPackageId());
			if (packageRes.isPresent()) {
				packages.add(packageRes.get());
			}
		}
		return packages;
	}

	@Override
	public void deletePackage(String packageId) {
		packageRepo.deleteById(packageId);
		userPackageService.deletePackage(packageId);
	}

}
