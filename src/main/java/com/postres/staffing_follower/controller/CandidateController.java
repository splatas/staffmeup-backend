package com.postres.staffing_follower.controller;

import com.postres.staffing_follower.entity.Candidate;
import com.postres.staffing_follower.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;


    @GetMapping(value = "/getcandidate/{id}")
    public Candidate getCandidate(@PathVariable(value = "id") Long id) {
        return candidateService.getCandidate(id);
    }

    @GetMapping(value = "/getbetween/{from}/{to}")
    public List<Candidate> getBetween(@PathVariable(value = "from") Long from, @PathVariable(value = "to") Long to){
        return candidateService.getBetween(from, to);
    }


    /*
    @RequestMapping(path = "/mno/objectKey/{id}/{name}", method = RequestMethod.GET)
public Book getBook(@PathVariable int id, @PathVariable String name) {
    // code here
}

     */

    @GetMapping(value = "/getcandidates")
    public List<Candidate> getCandidates() {
        return candidateService.getAll();
    }

    @GetMapping(value = "/getcandidatesview")
    public ResponseEntity getCandidatesView(){
        return ResponseEntity.ok(candidateService.getCandidatesView());
    }

    @PostMapping(value = "/savecandidate")
    public ResponseEntity saveTicket(@RequestBody Candidate candidate){
        candidateService.saveCandidate(candidate);
        return ResponseEntity.ok("Candidate saved");
    }


}
