package com.postres.staffing_follower.controller;

import com.postres.staffing_follower.entity.Priority;
import com.postres.staffing_follower.service.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/priority")
public class PriorityController {

    @Autowired
    private PriorityService priorityService;


    @GetMapping(value = "/getpriority/{id}")
    public ResponseEntity getPriority(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(priorityService.getPriority(id));
    }

    @GetMapping(value = "/getall")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(priorityService.getAll());
    }

    @PostMapping(value = "/savepriority")
    public ResponseEntity savePriority(@RequestBody Priority priority){
        priorityService.savePriority(priority);
        return ResponseEntity.ok("Priority saved");
    }


}
