package com.nationalexpress.spacecraft.services;

import com.nationalexpress.spacecraft.model.Location;
import com.nationalexpress.spacecraft.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    @Autowired
    LocationRepository locationRepository;

    public List<Location> findAllInUseLocations () {
        return locationRepository.findAllInUseLocations();
    }
}
