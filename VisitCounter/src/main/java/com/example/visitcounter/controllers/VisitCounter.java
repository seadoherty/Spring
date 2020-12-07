package com.example.visitcounter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VisitCounter {
	@RequestMapping("/")
	public String index(Model model, HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		if(count!=null) {			
			count+=1;			
		}else {
			session.setAttribute("count", 0);
		}		
		session.setAttribute("count", count);
		String name = "Human";
		model.addAttribute("name", name);
		return "index.jsp";
	}

	@RequestMapping("/counter")
	public String index(HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");		

		return "counter.jsp";
	}
}
