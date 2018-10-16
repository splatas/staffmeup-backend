package com.postres.staffing_follower.service;

import com.postres.staffing_follower.entity.Profile;
import com.postres.staffing_follower.entity.TicketHistory;

import com.postres.staffing_follower.pojo.TecnologyReport;
import com.postres.staffing_follower.repository.ProfileRepo;

import com.postres.staffing_follower.pojo.TicketCompareReport;

import com.postres.staffing_follower.repository.TicketHistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TicketHistoryService {

    @Autowired
    private TicketHistoryRepo ticketHistoryRepo;

    @Autowired
    private ProfileRepo profileRepo;


    public List<TicketHistory> getAll(){
        return ticketHistoryRepo.findAll();
    }

    public List<TicketHistory> getAllTicketHistory(Long idTicketHistory){
        return ticketHistoryRepo.findAllByIdTicketHistory(idTicketHistory);
    }

    public List<TicketHistory> getBetween(Date from, Date to){
        return ticketHistoryRepo.findByUpdateDateBetween(from, to);
    }

    public void saveTicketHistory (TicketHistory ticketHistory){
        ticketHistoryRepo.save(ticketHistory);
    }

    public List<TicketHistory> getAllOrderByDate() {
        return ticketHistoryRepo.findAllByOrderByIdTicketAscUpdateDateDesc();
    }






    public List<TicketHistory> getTicketsTest(Date dateOne, Date dateTwo){
        return ticketHistoryRepo.getAllTheTicketsToCompare(dateOne, dateTwo);
    }





    public List<TicketCompareReport> getAllTheTicketsToCompare(Date dateOne, Date dateTwo){

        int i = 0;
        Long ticketIdAux = 0L;

        TicketCompareReport ticketReport = null;
        TicketHistory ticket;
        List<TicketCompareReport> ticketList = new ArrayList<>();
        List<TicketHistory> ticketHistoryList = ticketHistoryRepo.getAllTheTicketsToCompare(dateOne, dateTwo);


        if (!ticketHistoryList.isEmpty()){
            ticketIdAux = ticketHistoryList.get(0).getIdTicket();
            ticketReport = new TicketCompareReport();
        }


        while (i < ticketHistoryList.size()){

            ticket = ticketHistoryList.get(i);

            if (ticketIdAux == ticket.getIdTicket()){
                if (ticket.getUpdateDate().compareTo(dateOne) <= 0){
                    ticketReport.setTicketHistoryOne(ticket);
                }
                else{
                    ticketReport.setTicketHistoryTwo(ticket);
                }
            }
            else {
                ticketList.add(ticketReport);
                ticketReport = new TicketCompareReport();

                ticketIdAux = ticket.getIdTicket();

                if (ticket.getUpdateDate().compareTo(dateOne) <= 0){
                    ticketReport.setTicketHistoryOne(ticket);
                }
                else{
                    ticketReport.setTicketHistoryTwo(ticket);
                }
            }

            i++;
        }

        ticketList.add(ticketReport);

        return ticketList;

    }


    public List<TicketHistory> getATicketToCompare(Long idTicket, Date dateOne, Date dateTwo){
        return ticketHistoryRepo.getATicketToCompare(idTicket, dateOne, dateTwo);
    }


    public List<TicketHistory> getTheLastUpdate(){
        return ticketHistoryRepo.getTheLastUpdate();
    }






    // -----------------------

    public List<TicketHistory> getAllBeforeDate(Date date){
        return ticketHistoryRepo.findByUpdateDateLessThanEqualOrderByIdTicketAsc(date);
    }





    private TecnologyReport createOneTecnologyReport (String status, String profile){
        double total=0;
        double diference=0;
        double count=0;
        double max=0;
        double min=0;


        List<TicketHistory> ticketHistories = ticketHistoryRepo.findByStatusAndProfile(status,profile);

        for (TicketHistory ticketHistory: ticketHistories
        ) {

            diference=ticketHistory.getUpdateDate().getTime()-ticketHistory.getCreatedOn().getTime(); //In miliseconds
            diference=(diference)/(1000*60*60*24); // In days

            if (count==0){

                max=diference;
                min=diference;
            }

                max = Math.max(max, diference);
                min = Math.min(min, diference);
                count++;
                total += diference;

        }


        return new TecnologyReport(profile,total/count,max,min);
    }

    public List<TecnologyReport> createAllTecnologyReports(){

        List<Profile> profiles = profileRepo.findAll();
        List<TecnologyReport> report = new ArrayList<>();

        for (Profile profile : profiles
        ) {
            report.add(createOneTecnologyReport("Closed",profile.getDsProfile()));



        }

        return report;
    }


    public InputStream getStreamTechnologyReport() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Technology").append(",");
        buffer.append("Minimum").append(",");
        buffer.append("Maximum").append(",");
        buffer.append("Avarage").append(",");
        buffer.append("\n");
        List<TecnologyReport> technologies = createAllTecnologyReports();
        for (TecnologyReport tecnologyReport: technologies){
            buffer.append(tecnologyReport.getTecnologyName()).append(",");
            buffer.append(tecnologyReport.getMin()).append(",");
            buffer.append(tecnologyReport.getMax()).append(",");
            buffer.append(tecnologyReport.getAvarage()).append(",");
            buffer.append("\n");
        }

        return new ByteArrayInputStream(buffer.toString().getBytes(Charset.forName("UTF-8")));
    }



    public List<TicketHistory> getTicketsByUpdateDate(Date date){
        return ticketHistoryRepo.getTicketsByUpdateDate(date);
    }



}
