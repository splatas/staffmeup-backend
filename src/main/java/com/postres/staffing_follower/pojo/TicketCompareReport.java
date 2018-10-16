package com.postres.staffing_follower.pojo;

import com.postres.staffing_follower.entity.TicketHistory;

public class TicketCompareReport {

    private TicketHistory ticketHistoryOne;
    private TicketHistory ticketHistoryTwo;


    public TicketCompareReport() {
    }

    public TicketCompareReport(TicketHistory ticketHistoryOne, TicketHistory ticketHistoryTwo) {
        this.ticketHistoryOne = ticketHistoryOne;
        this.ticketHistoryTwo = ticketHistoryTwo;
    }


    public TicketHistory getTicketHistoryOne() {
        return ticketHistoryOne;
    }
    public void setTicketHistoryOne(TicketHistory ticketHistoryOne) {
        this.ticketHistoryOne = ticketHistoryOne;
    }
    public TicketHistory getTicketHistoryTwo() {
        return ticketHistoryTwo;
    }
    public void setTicketHistoryTwo(TicketHistory ticketHistoryTwo) {
        this.ticketHistoryTwo = ticketHistoryTwo;
    }
}
