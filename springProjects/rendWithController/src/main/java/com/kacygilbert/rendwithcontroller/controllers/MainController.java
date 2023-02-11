package com.kacygilbert.rendwithcontroller.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/")
	public String index(HttpSession session) {
		session.setAttribute("name", "Courtney");
		return "index.jsp";
	}
	
	@RequestMapping("/welcome")
	public String welcome(HttpSession session) {
		String userName=(String) session.getAttribute("name");
		System.out.println("The name is " + userName);
		
		return "welcome.jsp";
	}
}
