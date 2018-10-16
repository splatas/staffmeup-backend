package com.postres.staffing_follower.repository;

import com.postres.staffing_follower.entity.Seniority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeniorityRepo extends JpaRepository<Seniority,Long> {
    List<Seniority> findByDsSeniority(String description);
    List<Seniority> findByLevel(Integer description);
}
