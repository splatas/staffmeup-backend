package com.postres.staffing_follower.controller;

import com.postres.staffing_follower.entity.Status;
import com.postres.staffing_follower.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/status")
public class StatusController {

    @Autowired
    private StatusService statusService;


    @GetMapping(value = "/getall" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findAllStatus(){
        return ResponseEntity.ok(statusService.getAll());
    }

    @GetMapping(value="/getstatus/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findStatusByID(@PathVariable (value = "id") Long statusId){
        return ResponseEntity.ok(statusService.getStatus(statusId));
    }

    @PostMapping(value = "/savestatus" , consumes =MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity saveSatus(@RequestBody Status status){
        statusService.saveStatus(status);
        return ResponseEntity.ok().build();
    }



}

