package com.example.candidate.model;

import jakarta.persistence.*;

@Entity
@Table(name = "candidates")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String email;

    @Column(columnDefinition = "TEXT")
    private String cvText;

    private String skills; // java;spring;sql

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCvText() { return cvText; }
    public void setCvText(String cvText) { this.cvText = cvText; }

    public String getSkills() { return skills; }
    public void setSkills(String skills) { this.skills = skills; }
}
