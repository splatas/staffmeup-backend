package com.postres.staffing_follower.controller;

import com.postres.staffing_follower.entity.CandidateStatus;
import com.postres.staffing_follower.service.CandidateStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/candidatestatus")
public class CandidateStatusController {

    @Autowired
    private CandidateStatusService candidateStatusService;


    @GetMapping(value = "/getall",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findAllCandidateStatus(){
        return ResponseEntity.ok(candidateStatusService.getAll());
    }

    @GetMapping(value = "/findcandidatesatusbyid/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findCandidateSatusById(@PathVariable (value="id") Long idCandidateStatus){
        return ResponseEntity.ok(candidateStatusService.getStatus(idCandidateStatus));
    }

    @PostMapping(value = "/savecandidatestatus",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveCandidateStatus(@RequestBody CandidateStatus candidateStatus){
        candidateStatusService.saveCandidateStatus(candidateStatus);
        return ResponseEntity.ok().build();
    }
}

