package com.postres.staffing_follower.repository;

import com.postres.staffing_follower.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepo extends JpaRepository<Location,Long> {
    List<Location> findByDsLocation(String description);
}
