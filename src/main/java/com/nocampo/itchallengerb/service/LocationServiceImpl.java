package com.nocampo.itchallengerb.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.fedy2.weather.YahooWeatherService;
import com.github.fedy2.weather.YahooWeatherService.LimitDeclaration;
import com.github.fedy2.weather.data.Channel;
import com.github.fedy2.weather.data.unit.DegreeUnit;
import com.nocampo.itchallengerb.model.Location;
import com.nocampo.itchallengerb.repository.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService{

	@Autowired
	LocationRepository locationRepository;
	
	YahooWeatherService yahooWeather = new YahooWeatherService();

	

	@Override
	public Location getLocationById(String idLocation) {
			Location location = locationRepository.findById(idLocation).get();
			LimitDeclaration limit = yahooWeather.getForecastForLocation(location.getLocation(), DegreeUnit.CELSIUS);
			List<Channel> list = new ArrayList<Channel>();
			try {
				list = limit.all();
				location.setChannel(list.get(0));
			} catch (JAXBException | IOException e) {
				e.printStackTrace();
			}
			
			return location;
			
	}
	
	
	
	@Override
	public Location addLocation(String nameLocation) {
		Location location = new Location(nameLocation);
		Channel channel = new Channel();
		LimitDeclaration limitDeclaration = yahooWeather.getForecastForLocation(nameLocation, DegreeUnit.CELSIUS);
		List<Channel> list = new ArrayList<Channel>();
		try {
			
			list = limitDeclaration.all();
			if(!list.isEmpty()){
				 locationRepository.save(location);
				 channel = list.get(0);
			 }
			
		} catch (JAXBException | IOException e) {
			e.printStackTrace();
		}
		location.setChannel(channel);
		return location;
		 
	}
	
	
	@Override
	public Iterable<Location> getAllLocations() {
		Iterable<Location> locations = locationRepository.findAll();
					for(Location location:locations){
						LimitDeclaration limitDeclaration = yahooWeather.getForecastForLocation(location.getLocation(), DegreeUnit.CELSIUS);	
						List<Channel> list = new ArrayList<Channel>();
						try {
							list = limitDeclaration.all();
							location.setChannel(list.get(0));
						} catch (JAXBException | IOException e) {
							e.printStackTrace();
						}			
					}
		
		return locations;
	}
	
	
	@Override
	public void deleteLocation(String idLocation) {
		Location location = locationRepository.findById(idLocation).get();
        locationRepository.delete(location);	
	}
	
	public LocationServiceImpl() throws Exception {
		
	}



	




	


	
}
