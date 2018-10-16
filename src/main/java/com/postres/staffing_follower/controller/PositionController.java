package com.postres.staffing_follower.controller;

import com.postres.staffing_follower.entity.Position;
import com.postres.staffing_follower.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/position")
public class PositionController {

    @Autowired
    PositionService positionService;


    @GetMapping(value = "/getposition/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getPosition(@PathVariable(value = "id") Long idPosition) {
        return ResponseEntity.ok(positionService.getPosition(idPosition));
    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(positionService.getAll());
    }

    @PostMapping(value = "/saveposition", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity savePosition(@RequestBody Position position) {

        positionService.savePosition(position);
        return ResponseEntity.ok().build();
    }
}
