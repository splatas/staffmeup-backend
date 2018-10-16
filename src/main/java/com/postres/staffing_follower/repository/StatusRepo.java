package com.postres.staffing_follower.repository;


import com.postres.staffing_follower.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StatusRepo extends JpaRepository<Status,Long> {
    List<Status> findByDsStatus(String description);
}
