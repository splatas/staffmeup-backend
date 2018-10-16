package com.postres.staffing_follower.service;

import com.postres.staffing_follower.entity.Location;
import com.postres.staffing_follower.repository.LocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepo locationRepo;

    public Optional<Location> getLocation(Long id) {return locationRepo.findById(id);}

    public void saveLocation (Location location) {locationRepo.save(location);}

    public List<Location> getAll() {return locationRepo.findAll();}
}
