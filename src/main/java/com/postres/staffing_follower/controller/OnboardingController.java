package com.postres.staffing_follower.controller;

import com.postres.staffing_follower.entity.Onboarding;
import com.postres.staffing_follower.entity.Priority;
import com.postres.staffing_follower.service.OnboardingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/onboarding")
public class OnboardingController {

    @Autowired
    private OnboardingService onboardingService;


    @GetMapping(value = "/getonboarding/{id}")
    public ResponseEntity getOnboarding(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(onboardingService.getOnboarding(id));
    }

    @GetMapping(value = "/getall")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(onboardingService.getAll());
    }

    @PostMapping(value = "/saveonboarding")
    public ResponseEntity saveOnboarding(@RequestBody Onboarding onboarding){
        onboardingService.saveOnboarding(onboarding);
        return ResponseEntity.ok("Onboarding saved");
    }


}

