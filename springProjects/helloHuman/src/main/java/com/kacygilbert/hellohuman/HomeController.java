package com.kacygilbert.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@RequestMapping("/")
	public String index(@RequestParam(value="", required=false) String name, String last_name, String times) {
		String message = "Hello Human";
		int time;
		
		if(name != null) {
			message = " ";
		}
		if(times == null) {
			time = 1;
		} else {
			time = Integer.parseInt(times);
		}
		for(int i = 0; i < time; i++) {
			if(name != null) {
				if(last_name == null) {				
					message = message + "Hello " + name;
				} else {
					message = message + "Hello " + name + " " + last_name;
				}
			}
		}
		return message;
	}
}
//int counter = 1;
//int time = Integer.parseInt(times);
//String message = "";
//if (times == null) {
//	message = "Hello Human";
//}
//while (counter <=time) {	
//	if(name == null && last_name == null) {
//		message = message + " Hello Human ";
//	} else if(last_name == null) {
//		message = " Hello " + name + " ";
//	} else {
//		message =  " Hello " + name + " " + last_name + " ";
//	}
//}