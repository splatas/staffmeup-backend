package com.postres.staffing_follower.service;

import com.postres.staffing_follower.entity.Onboarding;
import com.postres.staffing_follower.repository.OnboardingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OnboardingService {

    @Autowired
    private OnboardingRepo onboardingRepo;


    public Optional<Onboarding> getOnboarding(Long id){return onboardingRepo.findById(id);}

    public void saveOnboarding (Onboarding onboarding) {
        onboardingRepo.save(onboarding);}

    public List<Onboarding> getAll() { return onboardingRepo.findAll();}

}

