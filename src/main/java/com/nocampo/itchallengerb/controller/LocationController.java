package com.nocampo.itchallengerb.controller;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;

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
import com.github.fedy2.weather.data.Channel;
import com.github.fedy2.weather.data.unit.DegreeUnit;
import com.nocampo.itchallengerb.model.Location;
import com.nocampo.itchallengerb.repository.LocationRepository;


@RestController
@CrossOrigin("*")
@RequestMapping("/boards/{userName}/")
public class LocationController {
	
	@Autowired
	LocationRepository locationRepository;
	
	YahooWeatherService service = new YahooWeatherService();
	
	
	
	@GetMapping("/verify")
	public String verifyConnection(@PathVariable String userName){
		return "Connection succesfull : "+userName;
	}
	
	@GetMapping(path = "/addLocation/{nameLocation}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Channel save(@PathVariable String nameLocation) throws JAXBException, IOException {
		 
		 LimitDeclaration limitDeclaration = service.getForecastForLocation(nameLocation, DegreeUnit.CELSIUS);
		 List<Channel> list = limitDeclaration.all();
		 if(!list.isEmpty()){
			 Location location = new Location(nameLocation);
			 locationRepository.save(location);
			 return list.get(0);
		 }
		 
		 return null;
	    }
	
	
	@GetMapping(path = "/locations",produces=MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Location> findAll() {
		 return locationRepository.findAll();	 
	}
	
	
	
	@GetMapping(path = "/location/{idLocation}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Location findById(@PathVariable String idLocation) {
		return locationRepository.findById(idLocation).get();	 
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/location/{idLocation}")
    public String deleteLocation(@PathVariable String idLocation) {
        Location location = locationRepository.findById(idLocation).get();
        locationRepository.delete(location);

        return "";
    }
	
	
	

	public LocationController() throws Exception {
		
	}
	
	
	
	
}
