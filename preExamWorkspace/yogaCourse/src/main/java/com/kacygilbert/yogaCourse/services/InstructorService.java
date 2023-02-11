package com.kacygilbert.yogaCourse.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.kacygilbert.yogaCourse.models.Instructor;
import com.kacygilbert.yogaCourse.models.LoginInstructor;
import com.kacygilbert.yogaCourse.repositories.InstructorRepository;

@Service
public class InstructorService {
	@Autowired
	private InstructorRepository instRepo;
	
	public Instructor register(Instructor newInstructor, BindingResult results) {
		if(newInstructor.getPassword().equals(newInstructor.getConfirmPassword())) {
			newInstructor.setPassword(BCrypt.hashpw(newInstructor.getPassword(), BCrypt.gensalt()));
			return instRepo.save(newInstructor);
		} else {
			results.rejectValue("confirmPassword", "Matches", "Passwords do not match");
			return null;
		}
	}
	
	public Instructor getOneById(Long id) {
		Optional<Instructor> instructor = instRepo.findById(id);
		if(instructor.isPresent()) {
			return instructor.get();
		} else {
			return null;
		}
	}
	
	public Instructor getOneByEmail(LoginInstructor loginInstructor, BindingResult results) {
		Optional<Instructor> instructor = instRepo.findByEmail(loginInstructor.getEmail()); // gets our optional user if or not present
		if(instructor.isPresent()) {
			if(BCrypt.checkpw(loginInstructor.getPassword(), instructor.get().getPassword())) {
				return instructor.get();
			} else {
				results.rejectValue("email", "login", "Invalid Username/Password");
				return null;
			}
		} else {
			results.rejectValue("email", "login", "Invalid Username/Password");
			return null;
		}
	}
	
	public List<Instructor> getAllUsers() {
		return instRepo.findAll();
	}

}
