package com.kacygilbert.authentication.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.kacygilbert.authentication.models.LoginUser;
import com.kacygilbert.authentication.models.User;
import com.kacygilbert.authentication.repositories.UserRepository;

@Service
 public class UserService {

    @Autowired
    private UserRepository userRepo;
    
    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult results) {
    	Optional<User> user = userRepo.findByEmail(newUser.getEmail());
        // TO-DO: Additional validations!
    	if(newUser.getPassword().equals(newUser.getConfirm())) {
    		// Hash password
    		newUser.setPassword(BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt()));
    		// Store in DB & return newUser
    		return userRepo.save(newUser);
    	} else if(user.isPresent()){
    		results.rejectValue("confirm", "login", "Email already exist, login instead.");
    	} else {
    		results.rejectValue("confirm", "Matches", "Passwords do not match");
    	}
        return null;
    }
    
    public User login(LoginUser loginUser, BindingResult results) {
    	Optional<User> user = userRepo.findByEmail(loginUser.getEmail());
        // TO-DO: Additional validations!
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

	public User getOneById(Long id) {
		Optional<User> user = userRepo.findById(id);
		if(user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
	}
	
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
}