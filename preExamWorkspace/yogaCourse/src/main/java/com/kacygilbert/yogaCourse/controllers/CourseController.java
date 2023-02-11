package com.kacygilbert.yogaCourse.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kacygilbert.yogaCourse.models.Course;
import com.kacygilbert.yogaCourse.services.CourseService;
import com.kacygilbert.yogaCourse.services.InstructorService;
import com.kacygilbert.yogaCourse.services.StudentService;

@Controller
@RequestMapping("/classes")
public class CourseController {
	@Autowired
	CourseService courseServ;
	@Autowired
	InstructorService instServ;
	@Autowired
	StudentService stuServ;
	
	@GetMapping("/new")
	public String newCourse(@ModelAttribute("course") Course course, Model model, HttpSession session) {
		Long id = (Long) session.getAttribute("instructorId");
		model.addAttribute("instructor", instServ.getOneById(id));
		return "newClass.jsp";
	}
	
	@PostMapping("/create")
	public String createListing(@Valid @ModelAttribute("course") Course course, BindingResult result) {
		if(result.hasErrors()) {
			return "newClass.jsp";
		} else {
			courseServ.createCourse(course);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/{id}")
	public String viewListing(@PathVariable("id") Long id, Model model, HttpSession session) {
		model.addAttribute("course", courseServ.getCourseById(id));
		model.addAttribute("instructor", instServ.getOneById((Long) session.getAttribute("instructorId")));
//		model.addAttribute("allNotes", noteServ.allNotes());
//		model.addAttribute("allUsers", userServ.getAllUsers());
		return "viewClass.jsp";
	}
//	
	@GetMapping("/{id}/edit")
	public String editCourse(@PathVariable("id") Long id, Model model) {
		model.addAttribute("course", courseServ.getCourseById(id));
		model.addAttribute("allCourses", courseServ.allCourses());
		return "editClass.jsp";
	}
	@PostMapping("/{id}/update")
	public String updateCourse(@Valid @ModelAttribute("course") Course course, BindingResult result) {
		if(result.hasErrors()) {
			return "editClass.jsp";
		} else {
			courseServ.updateCourse(course);
			return "redirect:/course/{id}";
		}
	}
	
	@DeleteMapping("/{id}/delete")
	public String deleteCourse(@PathVariable("id") Long id) {
		courseServ.deleteCourse(id);
		return "redirect:/dashboard";
	}

}
