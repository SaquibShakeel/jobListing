package com.shakeelmdsaquib.jobListing.repository;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.shakeelmdsaquib.jobListing.model.Job;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepositoryImpl implements SearchRepository {

    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;

    @Override
    public List<Job> findByText(String text) {

        List<Job> jobs = new ArrayList<>();

        MongoDatabase database = client.getDatabase("jobListingDB");
        MongoCollection<Document> collection = database.getCollection("Jobs");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("index", "default")
                        .append("text",
                        new Document("query", text)
                        .append("path", Arrays.asList("techs", "profile", "desc")))),
                        new Document("$sort",
                        new Document("exp", -1L)),
                        new Document("$limit", 10L)));

        result.forEach(doc -> jobs.add(converter.read(Job.class, doc)));

        return jobs;
    }
}
