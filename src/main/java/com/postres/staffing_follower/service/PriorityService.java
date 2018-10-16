package com.postres.staffing_follower.service;

import com.postres.staffing_follower.entity.Priority;
import com.postres.staffing_follower.repository.PriorityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriorityService {

    @Autowired
    private PriorityRepo priorityRepo;


    public Optional<Priority> getPriority(Long id){return priorityRepo.findById(id);}

    public void savePriority (Priority priority) {priorityRepo.save(priority);}

    public List<Priority> getAll() { return priorityRepo.findAll();}

}
