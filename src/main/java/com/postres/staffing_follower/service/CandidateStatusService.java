package com.postres.staffing_follower.service;


import com.postres.staffing_follower.entity.CandidateStatus;
import com.postres.staffing_follower.repository.CandidateStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateStatusService {

    @Autowired
    private  CandidateStatusRepo candidateStatusRepo;


    public List<CandidateStatus> getAll() {
        return candidateStatusRepo.findAll();
    }


    public Optional<CandidateStatus> getStatus(Long id){
        return candidateStatusRepo.findById(id);
    }

    public void saveCandidateStatus(CandidateStatus candidateStatus){
        candidateStatusRepo.save(candidateStatus);
    }



}