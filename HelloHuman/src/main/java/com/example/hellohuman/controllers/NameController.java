package com.example.hellohuman.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NameController {

	@RequestMapping("")
	public String index(Model model) {		
		String name = "Human";		
		model.addAttribute("name", name);
		return "index.jsp";
	}

	
	@RequestMapping("/test")
	public String test(Model model) {		
		String test = "Query Stuff";		
		model.addAttribute("test", test);
		return "query.jsp";
	}

}
