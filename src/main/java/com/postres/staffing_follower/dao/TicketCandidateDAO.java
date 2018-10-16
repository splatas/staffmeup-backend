package com.postres.staffing_follower.dao;

import com.postres.staffing_follower.entity.TicketCandidate;

import java.util.List;

public interface TicketCandidateDAO {
    List<TicketCandidate> getAllTicketsAndCandidates() throws Exception;
}
