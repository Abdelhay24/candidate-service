package com.example.candidate.dto;

public class CandidateRequest {

    private String name;
    private String email;
    private String cvText;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCvText() { return cvText; }
    public void setCvText(String cvText) { this.cvText = cvText; }
}
