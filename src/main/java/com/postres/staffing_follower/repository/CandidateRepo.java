package com.postres.staffing_follower.repository;

import com.postres.staffing_follower.entity.Candidate;
import com.postres.staffing_follower.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepo extends JpaRepository<Candidate, Long> {

    List<Candidate> findByTicket(Ticket ticket);

    List<Candidate> findByIdCandidateBetween(Long from, Long to);
}
