package com.postres.staffing_follower.controller;

import com.postres.staffing_follower.service.ImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/import")
public class ImportController {

    @Autowired
    private ImportService importService;

    private Logger logger = LoggerFactory.getLogger(ImportController.class);

    @GetMapping("/sheetTicketCandidate")
    public ResponseEntity<String> importSheetTicketCandidate(){
        try {
            importService.importSheetTicketCandidate();
            return ResponseEntity.ok("successful");
        } catch (Exception e) {
            logger.error("Import Error", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("failure");
        }
    }

}
