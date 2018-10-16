package com.postres.staffing_follower.repository;


import com.postres.staffing_follower.entity.CandidateStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateStatusRepo extends JpaRepository<CandidateStatus,Long> {
    List<CandidateStatus> findByDsCandidateStatus(String description);
}
