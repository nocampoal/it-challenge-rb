package com.nocampo.itchallengerb.controller;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.fedy2.weather.YahooWeatherService;
import com.github.fedy2.weather.YahooWeatherService.LimitDeclaration;
import com.github.fedy2.weather.data.unit.DegreeUnit;
import com.nocampo.itchallengerb.model.Location;
import com.nocampo.itchallengerb.repository.LocationRepository;
import com.nocampo.itchallengerb.service.LocationService;



@RestController
@CrossOrigin("*")
@RequestMapping("/boards/{userName}/")
public class LocationController {
	
	private static final Log LOG = LogFactory.getLog(LocationController.class);
	
	@Autowired
	LocationService locationService;

	
	@GetMapping(path = "/addLocation/{nameLocation}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Location saveLocation(@PathVariable String nameLocation) throws JAXBException, IOException {
		 LOG.info("Method: addLocation - PARAM: "+nameLocation);
		 Location location = locationService.addLocation(nameLocation);
		 return location;
	    }
	
	
	@GetMapping(path = "/locations",produces=MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Location> getAllLocations() {
		 Iterable<Location> lista = locationService.getAllLocations();
		 return lista; 
	}
	
	
	
	@GetMapping(path = "/location/{idLocation}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Location findById(@PathVariable String idLocation) throws JAXBException, IOException {
		Location location = locationService.getLocationById(idLocation);
		   return location;
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/location/{idLocation}")
    public String deleteLocation(@PathVariable String idLocation) {
		locationService.deleteLocation(idLocation);
        return "";
    }
	
	

	@GetMapping("/verify")
	public String verifyConnection(@PathVariable String userName){
		LOG.info("Method: verify ");
		return "Connection succesfull : "+userName;
	}

	public LocationController() throws Exception {
		
	}
	
	
	
	
}
