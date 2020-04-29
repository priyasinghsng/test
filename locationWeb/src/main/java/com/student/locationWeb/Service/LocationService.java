package com.student.locationWeb.Service;

import java.util.List;

import com.student.locationWeb.Model.Location;

public interface LocationService {

	Location savelocation(Location location);
	Location updateLocation(Location location);
	void deleteLocation(Location location);
	Location getLocationById(int id);
	List<Location> getAllLocation();
	
	
}
