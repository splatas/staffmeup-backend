package com.postres.staffing_follower.repository;

import com.postres.staffing_follower.entity.Priority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PriorityRepo extends JpaRepository<Priority, Long> {
    List<Priority> findByDsPriority(String description);
}
