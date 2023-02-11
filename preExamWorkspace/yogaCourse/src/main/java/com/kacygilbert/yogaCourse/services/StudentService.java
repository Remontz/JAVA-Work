package com.kacygilbert.yogaCourse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kacygilbert.yogaCourse.models.Student;
import com.kacygilbert.yogaCourse.repositories.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepo;
	
	public List<Student> allListings() {
		return studentRepo.findAll();
	}
	public Student getStudentById(Long id) {
		Optional<Student> optionalStudent = studentRepo.findById(id);
		if(optionalStudent.isPresent()) {
			return optionalStudent.get();
		} else {
			return null;
		}
	}
	
	public Student createStudent(Student newStudent) {
		return studentRepo.save(newStudent);
	}
	
	public void updateStudent(Student student) {
		studentRepo.save(student);
	}
	public void deleteStudent(Long id) {
		studentRepo.deleteById(id);
	}
}
