package com.postres.staffing_follower.controller;

import com.postres.staffing_follower.entity.Seniority;
import com.postres.staffing_follower.service.SeniorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/seniority")
public class SeniorityController {

    @Autowired
    SeniorityService seniorityService;


    @GetMapping(value = "/getseniority/{id}", produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity getIdSeniority(@PathVariable(value = "id") Long idSeniority) {
        return ResponseEntity.ok(seniorityService.getSeniority(idSeniority));
    }



    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(seniorityService.getAll());
    }




        @PostMapping(value = "/saveseniority", consumes = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity saveSeniority (@RequestBody Seniority seniority){

            seniorityService.saveSeniority(seniority);
            return ResponseEntity.ok().build();
        }
    }

