package com.postres.staffing_follower.service;

import com.postres.staffing_follower.entity.Status;
import com.postres.staffing_follower.entity.Ticket;
import com.postres.staffing_follower.pojo.TicketOnlyView;
import com.postres.staffing_follower.repository.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.*;

@Service
public class TicketService {
    @Autowired
    private StatusService statusService;

    @Autowired
    private TicketRepo ticketRepo;


    public Ticket getTicket(Long id) {
        return ticketRepo.getOne(id);
    }

    public List<Ticket> getAll() {
        return ticketRepo.findAll();
    }

    public void saveTicket(Ticket ticket) {ticketRepo.save(ticket);

    }

    /**
     * <h1>getOnlyTickets</h1>
     * <p>Only the values ​​selected in the fromEntityToPojo method are displayed</p>
     */
    public List<TicketOnlyView> getOnlyTickets() {

        List<Ticket> tickets = getAll();
        List<TicketOnlyView> ticketsView = new ArrayList<>();

        for (Ticket t: tickets) {
            ticketsView.add(fromEntityToPojo(t));
        }

        return ticketsView;
    }

    /**
     * <h1>fromEntityToPojo</h1>
     * <p>take the values form entity ​​to save them in a object from TicketOnlyView
     * @param ticket - ticket to convert to a ticket view
     * @return Object.toString: return an empty String instead of a null</p>
     */
    private TicketOnlyView fromEntityToPojo(Ticket ticket) {

        TicketOnlyView ticketPojo;

        Long   idTicket    = ticket.getIdTicket();
        String project     = Objects.toString(ticket.getProject(),"");
        String description = Objects.toString(ticket.getDescription());
        String profile     = "";

        if(ticket.getProfile() != null){
            profile = Objects.toString(ticket.getProfile().getDsProfile(),"");
        }

        String seniority   = "";
        if(ticket.getSeniority()!= null){
            seniority = Objects.toString(ticket.getSeniority().getDsSeniority(),"");
        }

        String position    = "";

        if(ticket.getPosition()!= null){
            position = Objects.toString(ticket.getPosition().getDsPosition(),"");
        }

        Date   createdOn   = ticket.getCreatedOn();
        Date   startDate   = ticket.getStartDate();

        String location    = "";

        if(ticket.getLocation()!= null){
            location = Objects.toString(ticket.getLocation().getDsLocation(),"");
        }
        String status      = "";

        if(ticket.getStatus()!= null){
            status = Objects.toString(ticket.getStatus().getDsStatus(),"");
        }

        ticketPojo = new TicketOnlyView( idTicket
                                        ,project
                                        ,description
                                        ,profile
                                        ,seniority
                                        ,position
                                        ,createdOn
                                        ,startDate
                                        ,location
                                        ,status );

        return ticketPojo;

    }

    public  Map<String, Long> createTicketReport(){



        List<Status> allStatus = statusService.getAll();

        Map<String, Long> statusCounter = new HashMap<>();

        allStatus.stream().forEach(status -> statusCounter.put(status.getDsStatus(), ticketRepo.countByStatus(status)));





        return statusCounter;
    }


    public InputStream getStreamTicketReport () {
        StringBuffer buffer = new StringBuffer();
        buffer.append("State").append(",");
        buffer.append("Quantity");
        buffer.append("\n");
        Map<String, Long> map = createTicketReport();

        for (Map.Entry<String,Long> entry : map.entrySet()) {
            buffer.append(entry.getKey()).append(",");
            buffer.append(entry.getValue());
            buffer.append("\n");


        }
        return new ByteArrayInputStream(buffer.toString().getBytes(Charset.forName("UTF-8")));
    }






}