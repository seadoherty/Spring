package com.dojosurvey.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DojoSurveyController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}

	@RequestMapping(value = "/formInfo", method = RequestMethod.POST)
	public String formInfo(
			@RequestParam(value = "name") String name, 
			@RequestParam(value = "location") String location,
			@RequestParam(value = "language") String language, 
			@RequestParam(value = "comment") String comment,
			HttpSession session) {
		session.setAttribute("name", name);
		session.setAttribute("location", location);
		session.setAttribute("language", language);
		session.setAttribute("comment", comment);
		
		if(language.contains("Java")) {
			return "redirect:/java";
		}else {
			return "redirect:/details";			
		}		
	}

	@RequestMapping("/details")
	public String details(HttpSession session) {
		session.getAttribute("name");
		session.getAttribute("location");
		session.getAttribute("language");
		session.getAttribute("comment");		
		return "details.jsp";
	}
	
	@RequestMapping("/java")
	public String java(HttpSession session) {
		session.getAttribute("name");
		session.getAttribute("location");
		session.getAttribute("language");
		session.getAttribute("comment");		
		return "java.jsp";
	}

}
