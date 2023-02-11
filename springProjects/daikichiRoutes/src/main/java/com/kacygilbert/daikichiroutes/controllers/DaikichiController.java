package com.kacygilbert.daikichiroutes.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/daikichi")
public class DaikichiController {
	@RequestMapping("")
	public String index() {
		return "Welcome!";
	}
	@RequestMapping("/today")
	public String today() {
		return "Today you will find luck in all your endeavors!";
	}
	@RequestMapping("/tomorrow")
	public String tomorrow() {
		return "Tomorrow, an oppurtinity will arise, so be sure to be open to new ideas!";
	}
	@RequestMapping("/travel/{city}")
	public String travelTo(@PathVariable("city") String city) {
		return "Congratulations! You will soon travel to " + city;
	}
	@RequestMapping("/lotto/{number}")
	public String lottoResult(@PathVariable("number") int number) {
		String result = "";
		boolean even;
		if(number%2 == 0) {
			even = true;
		} else {
			even = false;
		}
		if(!even) {
			result = "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
		} else {
			result = "You will take a grand journey in the near future, but be weary of tempting offers.";
		}
			
		return result;
	}
	
	@GetMapping("/omikuji")
	public String omikuji() {
		
		return "omikuji.jsp";
	}
	
	@PostMapping("/processFormData")
	public String process(
			@RequestParam("number") int number,
			@RequestParam("city") String city,
			@RequestParam("person") String person,
			@RequestParam("hobby") String hobby,
			@RequestParam("livingThing") String livingThing,
			@RequestParam("said") String said,
			HttpSession session
			) {
		String resultOmikuji = String.format("In %s years you will live in %s as your roommate, %s.  The next time you see a(n) %s %s, you will have good luck.  Also, %s", number, city, person, livingThing, hobby, said);
		
		session.setAttribute("resultOmikuji", resultOmikuji);
		
		return "redirect:/daikichi/omikuji/show";
	}
	
	@GetMapping("/omikuji/show")
	public String show(HttpSession session, Model model) {
		
		String result = (String) session.getAttribute("resultOmikuji");
		model.addAttribute("result", result);
		
		return "showOmikuji.jsp";
	}
}
