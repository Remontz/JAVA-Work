package com.kacygilbert.houseHunter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class HouseHunterApplication {

//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return builder.sources(HouseHunterApplication.class);
//	}
	public static void main(String[] args) {
		SpringApplication.run(HouseHunterApplication.class, args);
	}

}
