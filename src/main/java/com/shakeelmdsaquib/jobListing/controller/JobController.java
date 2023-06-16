package com.shakeelmdsaquib.jobListing.controller;


import com.shakeelmdsaquib.jobListing.model.Job;
import com.shakeelmdsaquib.jobListing.repository.JobRepository;
import com.shakeelmdsaquib.jobListing.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
public class JobController {

    @Autowired
    JobRepository repo;

    @Autowired
    SearchRepository srepo;

    @GetMapping("/")
    public String greeting() {
        System.out.println(repo);
        return "Hello World";
    }

    @GetMapping("/jobs")
    public List<Job> getAllJobs() {
        return repo.findAll();
    }

    @GetMapping("/jobs/{text}")
    public List<Job> searchJobs(@PathVariable String text) {
        return srepo.findByText(text);
    }

    @PostMapping("/job")
    public Job addJobPost(@RequestBody Job job) {
        repo.save(job);
        return job;
    }

}
