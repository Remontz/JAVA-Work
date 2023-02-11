package com.kacygilbert.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/hello")
	public String index() {
		return "Hello World!";
	}
	@RequestMapping("/new_route")
	public String newRoute() {
		return "I'm Kacy.";
	}
}
