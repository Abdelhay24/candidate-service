package com.example.candidate.controller;

import com.example.candidate.dto.CandidateRequest;
import com.example.candidate.dto.MatchRequest;
import com.example.candidate.dto.MatchResponse;
import com.example.candidate.model.Candidate;
import com.example.candidate.service.CandidateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

    private final CandidateService service;

    public CandidateController(CandidateService service) {
        this.service = service;
    }

    @PostMapping
    public Candidate create(@RequestBody CandidateRequest request) {
        return service.createCandidate(request);
    }

    @GetMapping
    public List<Candidate> getAll() {
        return service.getAll();
    }

    @PostMapping("/match")
    public List<MatchResponse> match(@RequestBody MatchRequest request) {
        return service.matchCandidates(request.getSkills());
    }
}
