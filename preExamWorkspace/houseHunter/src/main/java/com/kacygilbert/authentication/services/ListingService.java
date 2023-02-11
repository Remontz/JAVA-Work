package com.kacygilbert.authentication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kacygilbert.authentication.models.Listing;
import com.kacygilbert.authentication.repositories.ListingRepository;

@Service
public class ListingService {

	@Autowired
	private ListingRepository listingRepo;
	
	public List<Listing> allListings() {
		return listingRepo.findAll();
	}
	public Listing getListById(Long id) {
		Optional<Listing> optionalListing = listingRepo.findById(id);
		if(optionalListing.isPresent()) {
			return optionalListing.get();
		} else {
			return null;
		}
	}
	
	public Listing createListing(Listing newListing) {
		return listingRepo.save(newListing);
	}
	
	public void updateListing(Listing listing) {
		listingRepo.save(listing);
	}
	public void deleteListing(Long id) {
		listingRepo.deleteById(id);
	}
}
