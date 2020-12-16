package com.dojoninja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojoninja.models.Dojo;
import com.dojoninja.repositories.DojoRepository;

@Service
public class DojoService {

	@Autowired
	private DojoRepository dojoRepo;

	public Dojo createDojo(Dojo d) {
		return dojoRepo.save(d);
	}
	
	public List<Dojo> allDojos(){
		return dojoRepo.findAll();
	}
	
	public Dojo findDojo(Long id){
		Optional <Dojo> optionalDojo = dojoRepo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		}else {
			return null;
		}
	}
}
