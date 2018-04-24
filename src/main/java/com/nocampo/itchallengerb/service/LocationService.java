package com.nocampo.itchallengerb.service;



import com.nocampo.itchallengerb.model.Location;

 public	interface LocationService {

	Location getLocationById(String idLocation);

	Location addLocation(String nameLocation);

	Iterable<Location> getAllLocations();

	void deleteLocation(String idLocation);

}
