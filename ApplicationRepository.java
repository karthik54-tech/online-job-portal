package com.jobportal.backend.repository;

import com.jobportal.backend.entity.Application;
import com.jobportal.backend.entity.Job;
import com.jobportal.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByApplicant(User applicant);
    List<Application> findByJob(Job job);
    Optional<Application> findByJobAndApplicant(Job job, User applicant);
    Boolean existsByJobAndApplicant(Job job, User applicant);
}