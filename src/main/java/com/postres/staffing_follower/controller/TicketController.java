package com.postres.staffing_follower.controller;

import com.postres.staffing_follower.entity.Ticket;
import com.postres.staffing_follower.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;


    @GetMapping(value = "/getticket/{id}")
    public Ticket getTicket(@PathVariable(value = "id") Long id) {
        return ticketService.getTicket(id);
    }

    @GetMapping(value = "/gettickets")
    public List<Ticket> getTickets() {
        return ticketService.getAll();
    }

    @GetMapping(value = "/getonlytickets")
    public ResponseEntity getOnlyTickets(){
        return ResponseEntity.ok(ticketService.getOnlyTickets());
    }

    @PostMapping(value = "/saveticket")
    public ResponseEntity saveTicket(@RequestBody Ticket ticket){
        ticketService.saveTicket(ticket);
        return ResponseEntity.ok("Ticket saved");
    }

    @GetMapping(value = "/getticketreport",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getTicketReport(){
        return ResponseEntity.ok(ticketService.createTicketReport());}


    @GetMapping(value = "/downloadticketreport")
    public ResponseEntity<InputStreamResource>downloadTicketReport() {
        try{
            InputStream is = ticketService.getStreamTicketReport();
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + "TicketReport.csv").body(new InputStreamResource(is));

        }catch (Exception e){
            e.printStackTrace();
            return  null;

        }


    }


}
