package com.kacygilbert.relationships.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.kacygilbert.relationships.models.License;
import com.kacygilbert.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	private final LicenseRepository licRepo;
	
	public LicenseService(LicenseRepository licRepo) {
		this.licRepo = licRepo;
	}
	
	// CREATES a License
	public License createLicense(License newLicense) {
		return licRepo.save(newLicense);
	}
	
	// Returns ALL Licenses
	public ArrayList<License> allLicenses() {
		return licRepo.findAll();
	}
	
	// UPDATE a License
	public void updateLicense(License license) {
		licRepo.save(license);
	}
	
	// DELETE a License by Id
	public void deleteLicense(Long id) {
		licRepo.deleteById(id);
	}
}
