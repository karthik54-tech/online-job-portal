package com.jobportal.backend.repository;

import com.jobportal.backend.entity.Job;
import com.jobportal.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByIsActiveTrue();
    List<Job> findByEmployer(User employer);

    @Query("SELECT j FROM Job j WHERE j.isActive = true AND " +
           "(LOWER(j.title) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(j.companyName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(j.location) LIKE LOWER(CONCAT('%', :keyword, '%')))")
    List<Job> searchJobs(String keyword);
}