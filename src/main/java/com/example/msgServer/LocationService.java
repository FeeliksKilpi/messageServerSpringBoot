package com.example.msgServer;
import java.util.ArrayList;
import java.util.List;

import com.example.msgServer.domain.Channel;
import com.example.msgServer.domain.Location;
import com.example.msgServer.domain.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    @Autowired
    LocationRepository lrepo;

    public List<Location> getAllLocations() {
        List<Location> locations = new ArrayList<>();
        lrepo.findAll().forEach(locationFound -> locations.add(locationFound));
        return locations;
    }

    // Get location by ID
    public Location getLocationById(long id) {
        return lrepo.findById(id).get();
    }

    public Location getLocationByName(String location) {
        return lrepo.findByLocation(location).get(0);
    }

    public void saveOrUpdate(Location location) {
        lrepo.save(location);
    }

    public void delete(long id) {
        lrepo.deleteById(id);
    }
}
