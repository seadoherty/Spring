package com.language.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.language.models.Language;
import com.language.services.LanguageService;

@RestController
public class LanguageAPI {
	private final LanguageService languageService;

	public LanguageAPI(LanguageService languageService) {
		this.languageService = languageService;
	}

	@GetMapping("/api/language")
	public List<Language> index() {
		return languageService.allLanguages();
	}

	@PostMapping(value = "/api/language")
	public Language create(
			@RequestParam(value = "name") String name, 
			@RequestParam(value = "creator") String creator,
			@RequestParam(value = "currentVersion") String currentVersion) {
		Language language = new Language(name, creator, currentVersion);
		return languageService.createLanguage(language);
	}

	@DeleteMapping(value = "/api/language/{id}")
	public void destroy(
			@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
	}
	
	@GetMapping("/api/language/{id}")
    public Language show(@PathVariable("id") Long id) {
		Language language = languageService.findLanguage(id);
        return language;
    }

}
