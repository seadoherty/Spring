package com.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.authentication.models.User;
import com.authentication.services.UserService;
import com.authentication.validators.UserValidator;

@Controller
public class UserController {
	@Autowired
	private UserService uServ;

	@Autowired
	private UserValidator uValid;
	
	@GetMapping("/registration")
	public String registerForm(@ModelAttribute("user") User user) {
		return "registrationPage.jsp";
	}

	@PostMapping("/registration")
	public String registerUser(
			@Valid @ModelAttribute("user") User regUser, 
			BindingResult result, 
			HttpSession session) {
		uValid.validate(regUser, result);
		
		if (result.hasErrors()) {
			return "registrationPage.jsp";
		}
		User u = uServ.registerUser(regUser);
		session.setAttribute("user_id", u.getId());
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String login() {
		return "loginPage.jsp";
	}

	@PostMapping("/login")
	public String loginUser(
			@RequestParam("email") String email, 
			@RequestParam("password") String password,
			RedirectAttributes redirectAttributes, 
			HttpSession session) {
		boolean isAuthenticated = uServ.authenticateUser(email, password);
		
		if (!isAuthenticated) {
			redirectAttributes.addFlashAttribute("error", "INVALID CREDENTIALS");
			return "redirect:/login";
		}
		User loggedUser = uServ.findByEmail(email);
		session.setAttribute("user_id", loggedUser.getId());
		return "redirect:/home";
	}

	@GetMapping("/home")
	public String home(
			HttpSession session, 
			Model model) {
		Long authId = (Long) session.getAttribute("user_id");
		User authUser = uServ.findUserById(authId);
				
		model.addAttribute("user", authUser);
		return "/homePage.jsp";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}
