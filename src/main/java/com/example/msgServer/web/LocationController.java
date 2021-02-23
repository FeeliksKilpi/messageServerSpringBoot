package com.example.msgServer.web;

import java.util.List;
import com.example.msgServer.LocationService;
import com.example.msgServer.domain.Channel;
import com.example.msgServer.domain.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {
    @Autowired
    LocationService locationService;

@CrossOrigin
@GetMapping("/locations")
private List <Location> getAllLocations() {
    return locationService.getAllLocations();
}

@CrossOrigin
@GetMapping("/location/{location}")
private Location getLocation(@PathVariable("location") String location) {
    return locationService.getLocationByName(location);
}

}
