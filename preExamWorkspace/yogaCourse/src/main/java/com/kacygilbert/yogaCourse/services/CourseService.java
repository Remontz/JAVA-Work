package com.kacygilbert.yogaCourse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kacygilbert.yogaCourse.models.Course;
import com.kacygilbert.yogaCourse.repositories.CourseRepository;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepo;
	
	public List<Course> allCourses() {
		return courseRepo.findAll();
	}
	public Course getCourseById(Long id) {
		Optional<Course> optionalCourse = courseRepo.findById(id);
		if(optionalCourse.isPresent()) {
			return optionalCourse.get();
		} else {
			return null;
		}
	}
	
	public Course createCourse(Course newCourse) {
		return courseRepo.save(newCourse);
	}
	
	public void updateCourse(Course course) {
		courseRepo.save(course);
	}
	public void deleteCourse(Long id) {
		courseRepo.deleteById(id);
	}
	
}
