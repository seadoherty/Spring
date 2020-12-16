package com.dojoninja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojoninja.models.Ninja;
import com.dojoninja.repositories.NinjaRepository;

@Service
public class NinjaService {

	@Autowired
	private NinjaRepository ninjaRepo;
	
	public Ninja createNinja(Ninja n) {
		return ninjaRepo.save(n);
	}
	
	public List<Ninja>allNinjas(){
		return ninjaRepo.findAll();
	}
}
