package com.nocampo.itchallengerb.controller;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nocampo.itchallengerb.model.Location;
import com.nocampo.itchallengerb.service.LocationService;



@RestController
@CrossOrigin("*")
@RequestMapping("/boards/{userName}/")
public class LocationController {
	
	private static final Log LOG = LogFactory.getLog(LocationController.class);
	
	@Autowired
	LocationService locationService;

	
	@PostMapping(path = "/location",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Location> addLocation(@RequestBody String nameLocation)  {
		 LOG.info("Method: addLocation - PARAM: "+nameLocation);
		 Location location = new Location();
		try {
			location = locationService.addLocation(nameLocation);
		} catch (Exception e) {
			LOG.error("addLocation error: "+e.getMessage());
			 return new ResponseEntity<Location>(location, HttpStatus.NOT_FOUND); 
		}
		 return new ResponseEntity<Location>(location, HttpStatus.OK); 
	    }
	
	
	@GetMapping(path = "/locations",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<Location>> getAllLocations() {
		 Iterable<Location> lista = locationService.getAllLocations();
		 return new ResponseEntity<Iterable<Location>>(lista, HttpStatus.OK); 
	}
	
	
	
	@GetMapping(path = "/location/{idLocation}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Location> findById(@PathVariable String idLocation) {
			Location location = new Location();
			try {
				location = locationService.getLocationById(idLocation);
			} catch (Exception e) {
				LOG.error("findById Yahoo weather error");
				return  new ResponseEntity<Location>(location, HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<Location>(location, HttpStatus.OK); 
	}
	
	
	@RequestMapping(method=RequestMethod.DELETE, value="/location/{idLocation}")
    public ResponseEntity<String> deleteLocation(@PathVariable String idLocation) {
		locationService.deleteLocation(idLocation);
		return new ResponseEntity<String>("", HttpStatus.OK); 
    }
	
	

	@GetMapping("/verify")
	public String verifyConnection(@PathVariable String userName){
		LOG.info("Method: verify ");
		return "Connection succesfull : "+userName;
	}

	
	
	
	
}
