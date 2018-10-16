package com.postres.staffing_follower.repository;

import com.postres.staffing_follower.entity.Status;
import com.postres.staffing_follower.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepo extends JpaRepository<Ticket, Long> {

    Long countByStatus(Status status);

}
