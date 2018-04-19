package com.nocampo.itchallengerb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nocampo.itchallengerb.repository.LocationRepository;

@RestController
@CrossOrigin("*")
public class LocationController {
	
	@Autowired
	LocationRepository locationRepository;
	
	
	@GetMapping("/verify")
	public String verifyConnection(){
		return "Connection succesfull";
	}

}
