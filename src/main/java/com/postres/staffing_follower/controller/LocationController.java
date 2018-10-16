package com.postres.staffing_follower.controller;

import com.postres.staffing_follower.entity.Location;
import com.postres.staffing_follower.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/location")
public class LocationController {

    @Autowired
    private LocationService locationService;


    @GetMapping(value = "/getlocation/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getLocation(@PathVariable(value = "id") Long idLocation) {
        return ResponseEntity.ok(locationService.getLocation(idLocation));
    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(locationService.getAll());
    }

    @PostMapping(value = "/savelocation", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveLocation(@RequestBody Location location) {
        locationService.saveLocation(location);
        return ResponseEntity.ok().build();
    }
}
