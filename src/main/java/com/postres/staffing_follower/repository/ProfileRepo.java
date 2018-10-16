package com.postres.staffing_follower.repository;

import com.postres.staffing_follower.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileRepo extends JpaRepository<Profile,Long> {
    List<Profile> findByDsProfile(String description);
}
