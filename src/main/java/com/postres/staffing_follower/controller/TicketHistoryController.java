package com.postres.staffing_follower.controller;

import com.postres.staffing_follower.entity.TicketHistory;
import com.postres.staffing_follower.pojo.TecnologyReport;
import com.postres.staffing_follower.service.TicketHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/tickethistory")
public class TicketHistoryController {

    @Autowired
    TicketHistoryService ticketHistoryService;


    @GetMapping(value = "/gethistory/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getHistoryById(@PathVariable (value = "id") Long idTicket){
        return ResponseEntity.ok(ticketHistoryService.getAllTicketHistory(idTicket));
    }

    @GetMapping(value = "/getbetween/{from}/{to}")
    public ResponseEntity getBetween(@PathVariable(value = "from") @DateTimeFormat(pattern = "yyyyMMdd") Date from, @PathVariable(value = "to") @DateTimeFormat(pattern = "yyyyMMdd") Date to) {
        return ResponseEntity.ok(ticketHistoryService.getBetween(from, to));
    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll(){
        return ResponseEntity.ok(ticketHistoryService.getAllOrderByDate());
    }

    @PostMapping(value = "/savehistory", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveHistory(@RequestBody TicketHistory ticketHistory){
        ticketHistoryService.saveTicketHistory(ticketHistory);
        return ResponseEntity.ok().build();
    }



    // -----------------------------------------------

    @GetMapping(value = "/getbeforedate/{date}")
    public ResponseEntity getBeforeBate(@PathVariable(value = "date") @DateTimeFormat(pattern = "yyyyMMdd") Date date) {
        return ResponseEntity.ok(ticketHistoryService.getAllBeforeDate(date));
    }




    @GetMapping(value = "/gettecnologyreport",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getTecnologyReport(){

        return ResponseEntity.ok(ticketHistoryService.createAllTecnologyReports());
    }


    @GetMapping("/downloadTechnologyReport")
    public ResponseEntity<InputStreamResource> downloadTechnologyReport() {
        try {
            InputStream is = ticketHistoryService.getStreamTechnologyReport();
            return ResponseEntity
                    .ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + "TechnologyReport.csv")
                    .body(new InputStreamResource(is));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping(value = "/getticketsbyupdatedate/{date}")
    public ResponseEntity getTicketsByUpdateDate(@PathVariable(value = "date") @DateTimeFormat(pattern = "yyyyMMdd") Date date){
        return ResponseEntity.ok(ticketHistoryService.getTicketsByUpdateDate(date));
    }


    @GetMapping(value = "/getatickettocompare/{idTicket}/{dateOne}/{dateTwo}")
    public ResponseEntity getATicketToCompare( @PathVariable(value = "idTicket") Long idTicket
                                              ,@PathVariable(value = "dateOne") @DateTimeFormat(pattern = "yyyyMMdd") Date dateOne
                                              ,@PathVariable(value = "dateTwo") @DateTimeFormat(pattern = "yyyyMMdd") Date dateTwo ){
        return ResponseEntity.ok(ticketHistoryService.getATicketToCompare(idTicket, dateOne, dateTwo));
    }


    @GetMapping(value = "/getthelastupdate")
    public ResponseEntity getTheLastUpdate(){
        return ResponseEntity.ok(ticketHistoryService.getTheLastUpdate());
    }


    @GetMapping(value = "/getticketstest/{dateOne}/{dateTwo}")
    public ResponseEntity getTicketsTest( @PathVariable(value = "dateOne") @DateTimeFormat(pattern = "yyyyMMdd") Date dateOne
                                         ,@PathVariable(value = "dateTwo") @DateTimeFormat(pattern = "yyyyMMdd") Date dateTwo ) {
        return ResponseEntity.ok(ticketHistoryService.getTicketsTest(dateOne, dateTwo));
    }

}
