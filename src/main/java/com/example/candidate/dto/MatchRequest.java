package com.example.candidate.dto;

import java.util.List;

public class MatchRequest {
    private List<String> skills;

    public List<String> getSkills() { return skills; }
    public void setSkills(List<String> skills) { this.skills = skills; }
}
