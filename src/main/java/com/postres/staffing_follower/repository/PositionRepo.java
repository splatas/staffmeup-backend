package com.postres.staffing_follower.repository;

import com.postres.staffing_follower.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PositionRepo extends JpaRepository<Position,Long> {
    List<Position> findByDsPosition(String description);
}
