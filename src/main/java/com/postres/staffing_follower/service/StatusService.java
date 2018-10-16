package com.postres.staffing_follower.service;


import com.postres.staffing_follower.entity.Status;
import com.postres.staffing_follower.repository.StatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class StatusService {

    @Autowired
    private StatusRepo statusRepo;



    public List<Status> getAll(){

        return statusRepo.findAll();
    }


    public Optional<Status> getStatus(Long statusId){

        return statusRepo.findById(statusId);
    }


    public void saveStatus(Status status){
        statusRepo.save(status);

    }


}

