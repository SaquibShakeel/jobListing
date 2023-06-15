package com.shakeelmdsaquib.jobListing.repository;

import com.shakeelmdsaquib.jobListing.model.Job;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends MongoRepository<Job, String> {
}
