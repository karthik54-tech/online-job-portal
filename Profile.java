package com.jobportal.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    private String headline;

    @Column(columnDefinition = "TEXT")
    private String bio;

    @Column(columnDefinition = "TEXT")
    private String skills;

    @Column(name = "experience_years")
    private Integer experienceYears = 0;

    private String education;

    @Column(name = "resume_url")
    private String resumeUrl;

    @Column(name = "profile_picture_url")
    private String profilePictureUrl;

    @Column(name = "linkedin_url")
    private String linkedinUrl;

    @Column(name = "github_url")
    private String githubUrl;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}