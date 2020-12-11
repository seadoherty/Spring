package com.language.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.language.models.Language;
import com.language.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languageRepository;

	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	public List<Language> allLanguages() {
		return languageRepository.findAll();
	}

	public Language createLanguage(Language lang) {
		return languageRepository.save(lang);
	}

	public Language deleteLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if (optionalLanguage.isPresent()) {
			languageRepository.deleteById(id);
		}
		return null;
	}
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if (optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}
	
	public Language updateLanguage(
			Long id, 
			String name, 
			String creator, 
			String currentVersion) {
		Language language = this.findLanguage(id);
		language.setName(name);
		language.setCreator(creator);
		language.setCurrentVersion(currentVersion);
		return languageRepository.save(language);
	}
}
