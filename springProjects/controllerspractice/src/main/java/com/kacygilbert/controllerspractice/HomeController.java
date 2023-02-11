package com.kacygilbert.controllerspractice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class HomeController {
	@RequestMapping("")
	public String index() {
		return "This is accessed view http://your_server/simple/root";
	}
	@RequestMapping("/hello")
	public String hello() {
		return "hello world! What route did you use to access me?";
	}
	@RequestMapping("/goodbye")
	public String goodbye() {
		return "Goodbye world!";
	}
	@RequestMapping("/search")
	public String index(@RequestParam(value="q") String searchQuery) {
		return "You searched for: " + searchQuery;
	}
}
