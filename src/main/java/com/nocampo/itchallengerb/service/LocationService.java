package com.nocampo.itchallengerb.service;



import java.io.IOException;

import javax.xml.bind.JAXBException;

import com.nocampo.itchallengerb.model.Location;

 public	interface LocationService {

	Location getLocationById(String idLocation)throws JAXBException, IOException;

	Location addLocation(String nameLocation) throws  Exception;

	Iterable<Location> getAllLocations();

	void deleteLocation(String idLocation);

}
