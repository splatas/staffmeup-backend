package com.postres.staffing_follower.repository;

import com.postres.staffing_follower.entity.Onboarding;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OnboardingRepo extends JpaRepository<Onboarding, Long> {
    List<Onboarding> findByDsOnboarding(String description);
}
