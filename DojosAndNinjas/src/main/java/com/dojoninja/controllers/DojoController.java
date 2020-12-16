package com.dojoninja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojoninja.models.Dojo;
import com.dojoninja.models.Ninja;
import com.dojoninja.services.DojoService;
import com.dojoninja.services.NinjaService;

@Controller
public class DojoController {
	@Autowired
	private DojoService dojoServ;
	@Autowired
	private NinjaService ninjaServ;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/dojos/new";
	}
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "/newDojo.jsp";
	}
	
	@PostMapping("/dojos")
	public String createD(
			@Valid @ModelAttribute("dojo") Dojo dojo,
			BindingResult result) {
		if (result.hasErrors()) {
			return "/newDojo.jsp";
		}else {
			dojoServ.createDojo(dojo);
			return "redirect:/";
		}
	}
	
	@GetMapping("/dojos/{id}")
	public String dojoDetails(
			Model model,
			@PathVariable("id") Long id
	) {
		Dojo dojo = dojoServ.findDojo(id);
		model.addAttribute("dojo",dojo);
		
		List<Ninja> ninjas = ninjaServ.allNinjas();
		model.addAttribute("ninjas",ninjas);
		
		return "/dojoDetails.jsp";
	}
	

	
	
}
