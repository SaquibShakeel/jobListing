package com.shakeelmdsaquib.jobListing.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CronJobService {

    @Scheduled(fixedDelay = 14*60000)
    public void serv() {
        System.out.println("Running every  14 minutes");
    }
}
