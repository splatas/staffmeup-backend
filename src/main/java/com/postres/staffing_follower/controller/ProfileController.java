package com.postres.staffing_follower.controller;

import com.postres.staffing_follower.entity.Profile;
import com.postres.staffing_follower.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/profile")
public class ProfileController {

    @Autowired
    ProfileService profileService;


    @GetMapping(value="/getprofile/{id}" , produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity findProfileById(@PathVariable (value = "id") Long idProfile){
        return ResponseEntity.ok(profileService.getProfile(idProfile));
    }

    @GetMapping(value="/getall" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findAllProfiles(){
        return ResponseEntity.ok(profileService.getAll());
    }

    @PostMapping(value="/saveprofile", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveProfile(Profile profile){
        profileService.saveProfile(profile);
        return ResponseEntity.ok().build();
    }
}
