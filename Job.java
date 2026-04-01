package com.jobportal.backend.entity;

import com.jobportal.backend.enums.JobType;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    private String location;

    @Enumerated(EnumType.STRING)
    @Column(name = "job_type")
    private JobType jobType = JobType.FULL_TIME;

    @Column(name = "salary_min")
    private BigDecimal salaryMin;

    @Column(name = "salary_max")
    private BigDecimal salaryMax;

    @Column(name = "experience_required")
    private Integer experienceRequired = 0;

    @Column(name = "skills_required", columnDefinition = "TEXT")
    private String skillsRequired;

    private Integer openings = 1;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @ManyToOne
    @JoinColumn(name = "employer_id", nullable = false)
    private User employer;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}