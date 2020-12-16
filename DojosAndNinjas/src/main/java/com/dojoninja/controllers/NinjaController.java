package com.dojoninja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojoninja.models.Dojo;
import com.dojoninja.models.Ninja;
import com.dojoninja.services.DojoService;
import com.dojoninja.services.NinjaService;

@Controller
public class NinjaController {
	@Autowired
	private NinjaService ninjaServ;
	
	@Autowired
	private DojoService dojoServ;
	
	@GetMapping("/ninjas/new")
	public String newNinja(
			Model model,
			@ModelAttribute("ninja")Ninja emptyNinja) {
		List<Dojo> dojos = dojoServ.allDojos();
		model.addAttribute("dojos",dojos);
		return "/newNinja.jsp";
	}
	
	@PostMapping("/ninjas/new")
	public String createN(
			@Valid @ModelAttribute("ninja") Ninja filledNinja,
			BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			List<Dojo> dojos = dojoServ.allDojos();
			model.addAttribute("dojos",dojos);
			return "/newNinja.jsp";
		}else {
			ninjaServ.createNinja(filledNinja);
			return "redirect:/";
		}
	}
}
