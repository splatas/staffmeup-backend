package com.postres.staffing_follower.service;

import com.postres.staffing_follower.entity.Seniority;
import com.postres.staffing_follower.repository.SeniorityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeniorityService {


    @Autowired
    private SeniorityRepo seniorityRepo;

    public Optional<Seniority> getSeniority(Long id){return seniorityRepo.findById(id);}

    public void saveSeniority (Seniority seniority) {seniorityRepo.save(seniority);}

    public List<Seniority> getAll() { return seniorityRepo.findAll();}
}
