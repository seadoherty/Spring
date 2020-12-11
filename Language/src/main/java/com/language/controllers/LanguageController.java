package com.language.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.language.models.Language;
import com.language.services.LanguageService;

@Controller
public class LanguageController {
	private final LanguageService languageService;

	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}

	@RequestMapping("/language")
	public String index(Model model) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		return "/index.jsp";
	}

	@RequestMapping("/language/new")
	public String newLanguage(@ModelAttribute("language") Language language) {
		return "/index.jsp";
	}

	@PostMapping(value = "/language")
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		if (result.hasErrors()) {
			return "/index.jsp";
		} else {
			languageService.createLanguage(language);
			return "redirect:/language";
		}
	}

	@DeleteMapping(value = "/language/{id}")
	public String destroy(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/language";
	}

	@RequestMapping("/language/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Language language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "/edit.jsp";
	}

	@PutMapping(value = "/language/{id}")
	public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors()) {
			return "/edit.jsp";
		} else {
			languageService.updateLanguage(language.getId(), language.getName(), language.getCreator(),
					language.getCurrentVersion());
			return "redirect:/language";
		}
	}

	@RequestMapping("/language/{id}")
	public String detail(Model model, @PathVariable("id") Long id) {
		Language language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "/details.jsp";
	}

}
