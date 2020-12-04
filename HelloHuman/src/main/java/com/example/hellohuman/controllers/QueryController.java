package com.example.hellohuman.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryController {
	
	@RequestMapping("/")
	public String query(
			@RequestParam(value="name", required=false) String first,
			@RequestParam(value="last_name", required=false) String last) {
        if (first!=null && last!=null) {
        	return "Welcome " + first + " " + last +  "!";
        }else {
        	return "Welcome Human!";
        }
		
	}
}
