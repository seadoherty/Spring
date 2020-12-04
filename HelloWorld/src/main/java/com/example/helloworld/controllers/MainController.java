package com.example.helloworld.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	@RequestMapping("/")
	public String hello() {
		return "Hello World";
	}

	@RequestMapping("/random")
	public String thursday() {
		System.out.println("you are on thursday router");
		return "Hi and welcome to the application";
	}
	
	@RequestMapping("/shows/{show_id}/{user_id}")
	public String shows(@PathVariable("show_id")int s_id,@PathVariable("user_id")int u_id) {
		String showId = Integer.toString(s_id);
		String userId = Integer.toString(u_id);
		return "Show id: " + showId + " and user id: " + userId;
	}
}
