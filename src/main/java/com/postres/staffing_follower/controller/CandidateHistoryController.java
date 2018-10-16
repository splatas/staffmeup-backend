package com.postres.staffing_follower.controller;

import com.postres.staffing_follower.entity.CandidateHistory;
import com.postres.staffing_follower.service.CandidateHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/candidatehistory")
public class CandidateHistoryController {

    @Autowired
    CandidateHistoryService candidateHistoryService;


    @GetMapping(value = "/gethistory/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getHistoryById(@PathVariable(value = "id") Long idCandidate) {
        return ResponseEntity.ok(candidateHistoryService.getAllCandidateHistory(idCandidate));
    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(candidateHistoryService.getAllOrderedByDate());
    }

    @PostMapping(value = "savehistory", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveHistory(@RequestBody CandidateHistory candidateHistory) {
        candidateHistoryService.saveCandidateHistory(candidateHistory);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/getcandidatetocomparebyticket/{idTicket}/{dateOne}/{dateTwo}")
    public ResponseEntity getCandidateToCompareByTicket( @PathVariable(value = "idTicket") Long idTicket
                                                         ,@PathVariable(value = "dateOne")@DateTimeFormat(pattern = "yyyyMMdd") Date dateOne
                                                         ,@PathVariable(value = "dateTwo")@DateTimeFormat(pattern = "yyyyMMdd") Date dateTwo) {
        return ResponseEntity.ok(candidateHistoryService.getCandidatesToCompareByTicket(idTicket, dateOne, dateTwo));
    }








    @GetMapping(value = "/test/{dateOne}/{dateTwo}")
    public ResponseEntity test( @PathVariable(value = "dateOne") @DateTimeFormat(pattern = "yyyyMMdd") Date dateOne
                               ,@PathVariable(value = "dateTwo") @DateTimeFormat(pattern = "yyyyMMdd") Date dateTwo ) {
        return ResponseEntity.ok(candidateHistoryService.test(dateOne, dateTwo));
    }



}
