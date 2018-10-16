package com.postres.staffing_follower.service;


import com.postres.staffing_follower.entity.Profile;
import com.postres.staffing_follower.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepo profileRepo;


    public List<Profile> getAll(){

        return profileRepo.findAll();
    }

    public Optional<Profile> getProfile(Long id ){

        return profileRepo.findById(id);
    }

    public void saveProfile(Profile profile){

        profileRepo.save(profile);
    }


}
