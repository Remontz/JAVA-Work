package com.kacygilbert.bookBroker.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.kacygilbert.bookBroker.models.LoginUser;
import com.kacygilbert.bookBroker.models.User;
import com.kacygilbert.bookBroker.repositories.UserRepository;

@Service
 public class UserService {

    @Autowired
    private UserRepository userRepo;
    
	//we do not want to save passwords as raw text = hash and add validations(confirmPass)
	// check if passwords match
	public User register(User newUser, BindingResult results) {
		if (newUser.getPassword().equals(newUser.getConfirmPassword())) {
			// Hash password
			newUser.setPassword(BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt()));
			// Store in database & return newUser
			return userRepo.save(newUser);
		} else {
			results.rejectValue("confirmPass", "Matches", "Passwords do not match");
			return null;
		}
	}
	
	public User getOneById(Long id) {
		Optional<User> user = userRepo.findById(id);
		if(user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
	}
	
	public User getOneByEmail(LoginUser loginUser, BindingResult results) {
		Optional<User> user = userRepo.findByEmail(loginUser.getEmail()); // gets our optional user if or not present
		if(user.isPresent()) {
			if(BCrypt.checkpw(loginUser.getPassword(), user.get().getPassword())) {
				return user.get();
			} else {
				results.rejectValue("email", "login", "Invalid Username/Password");
				return null;
			}
		} else {
			results.rejectValue("email", "login", "Invalid Username/Password");
			return null;
		}
	}
	
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
}