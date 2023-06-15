package com.shakeelmdsaquib.jobListing.repository;

import com.shakeelmdsaquib.jobListing.model.Job;

import java.util.List;

public interface SearchRepository {

    List<Job> findByText(String text);

}
