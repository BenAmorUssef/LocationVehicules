package com.example.demo.service;

import com.example.demo.model.Client;
import com.example.demo.model.Counter;
import com.example.demo.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Query.*;
import static org.springframework.data.mongodb.core.query.Criteria.*;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.*;

@Service
public class CounterService {
    @Autowired
    private MongoOperations mongo;
    @Autowired
    MongoTemplate mongoTemplate;

    public int getNextSequence(String collectionName) {

        Counter counter = mongo.findAndModify(
                query(where("_id").is(collectionName)),
                new Update().inc("seq", 1),
                options().returnNew(true),
                Counter.class);

        return counter.getSeq();
    }
}