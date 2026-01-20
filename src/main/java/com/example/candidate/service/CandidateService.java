package com.example.candidate.service;

import com.example.candidate.dto.CandidateRequest;
import com.example.candidate.dto.MatchResponse;
import com.example.candidate.model.Candidate;
import com.example.candidate.repository.CandidateRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CandidateService {

    private final CandidateRepository repository;

    private static final List<String> KNOWN_SKILLS =
            List.of("java", "spring", "sql", "python", "docker");

    public CandidateService(CandidateRepository repository) {
        this.repository = repository;
    }

    public Candidate createCandidate(CandidateRequest request) {
        Candidate c = new Candidate();
        c.setName(request.getName());
        c.setEmail(request.getEmail());
        c.setCvText(request.getCvText());
        c.setSkills(extractSkills(request.getCvText()));
        return repository.save(c);
    }

    public List<Candidate> getAll() {
        return repository.findAll();
    }

    public List<MatchResponse> matchCandidates(List<String> requiredSkills) {
        return repository.findAll().stream()
                .map(c -> buildMatch(c, requiredSkills))
                .filter(r -> r.getMatchPercentage() >= 70)
                .toList();
    }

    private String extractSkills(String cvText) {
        return KNOWN_SKILLS.stream()
                .filter(s -> cvText.toLowerCase().contains(s))
                .collect(Collectors.joining(";"));
    }

    private MatchResponse buildMatch(Candidate c, List<String> requiredSkills) {
        List<String> candidateSkills = Arrays.asList(c.getSkills().split(";"));

        long matches = requiredSkills.stream()
                .filter(s -> candidateSkills.contains(s.toLowerCase()))
                .count();

        int percentage = (int) ((matches * 100.0) / requiredSkills.size());

        MatchResponse r = new MatchResponse();
        r.setId(c.getId());
        r.setName(c.getName());
        r.setEmail(c.getEmail());
        r.setSkills(c.getSkills());
        r.setMatchPercentage(percentage);

        return r;
    }
}
