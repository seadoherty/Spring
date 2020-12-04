package com.example.routingpractice.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	
	@RequestMapping("/{my_text}")
	public String feedback(@PathVariable("my_text") String u_txt) {
		String result = "";
		
		if (u_txt.equals("dojo")) {
			result = "The dojo is awesome!";
		} else if (u_txt.equals("burbank-dojo")) {
			result = "Burbank Dojo is located in Southern California";
		} else if (u_txt.equals("san-jose")) {
			result = "SJ dojo is the headquarters";
		} else {
			result = "Not found, passed variable: " + u_txt;
		}
		return result;
	}
}
