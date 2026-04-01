package com.jobportal.backend.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class JobRequest {
    private String title;
    private String description;
    private String companyName;
    private String location;
    private String jobType;
    private BigDecimal salaryMin;
    private BigDecimal salaryMax;
    private Integer experienceRequired;
    private String skillsRequired;
    private Integer openings;
}