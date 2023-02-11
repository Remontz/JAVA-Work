package com.kacygilbert.ninjaGold.controllers;

import java.util.ArrayList;
import java.util.Random;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class NinjaGoldController {
	ArrayList<String> result = new ArrayList<String>();
	String place = "";
	int gold =0;
	@GetMapping("/")
	public String index() {
		
		return "index.jsp";
	}
	
	@PostMapping("/processFormData")
	public String process(
			@RequestParam("place") String place,
			HttpSession session
			) {
		Random random = new Random();
		int randomNum = (10)+random.nextInt(11);
		int posNegBit = random.nextInt(2);
		int questRan = random.nextInt(51);
		
		String newResult = "";
		Date date = new Date();
		
		switch(place) {
		case "farm": 	gold = gold + randomNum;
						newResult = "You entered a " + place + " and earned " + randomNum + "GOLD." + date.toString();
						break;
		case "cave": 	randomNum = (5)+random.nextInt(6);
						gold = gold + randomNum;
						newResult = "You entered a " + place + " and earned " + randomNum + "GOLD." + date.toString();
						break;
		case "house": 	randomNum = (2)+random.nextInt(4);
						gold = gold + randomNum;
						newResult = "You entered a " + place + " and earned " + randomNum + "GOLD." + date.toString();
						break;
		case "quest": 	if(posNegBit == 0) {
							questRan = questRan * -1;
							newResult = "You venture on a " + place + " and lose " + questRan + "GOLD..." + date.toString();
						} else {
							newResult = "You venture on a " + place + " and earn " + questRan + "GOLD..." + date.toString();
						}
						gold = gold + questRan;
						break;	
		}
	
		result.add(newResult);
		session.setAttribute("result", result);
		session.setAttribute("gold", gold);
	
	return "redirect:/";
		}
}
