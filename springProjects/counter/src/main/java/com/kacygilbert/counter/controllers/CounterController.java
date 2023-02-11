package com.kacygilbert.counter.controllers;

import java.util.ArrayList;
import java.util.Random;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CounterController {
	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
		
    	// If the count is not already in session
		if (session.getAttribute("count") == null) {
		// Use setAttribute to initialize the count in session
			session.setAttribute("count", 0);
		}
		else {
		// increment the count by 1 using getAttribute and setAttribute
			Integer currentCount = (Integer) session.getAttribute("count");
			currentCount++;
			session.setAttribute("count", currentCount);
		}
		return "index.jsp";
	}
	
	@RequestMapping("/counter/")
	public String counter(HttpSession session, Model model, HttpServletRequest request) {
		Integer currentCount = 0;
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		} else {
			currentCount = (Integer) session.getAttribute("count");
		}
		
		model.addAttribute("count", currentCount);
		return "show_count.jsp";
	}
	
	@RequestMapping("/double/")
	public String doubleCount(HttpSession session, Model model, HttpServletRequest request) {
		Integer currentCount = 0;
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		} else {
			currentCount = (Integer) session.getAttribute("count");
			currentCount += 2;
			session.setAttribute("count", currentCount);
		}
		model.addAttribute("count", currentCount);
		return "show_count.jsp";
	}
	
	@RequestMapping("/reset/")
	public String reset(HttpSession session, Model model, HttpServletRequest request) {
		Integer currentCount = 0;
		session.setAttribute("count", 0);
		model.addAttribute("count", currentCount);
		
		return "index.jsp";
	}
}
