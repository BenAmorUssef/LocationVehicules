package com.example.demo.repository;

import com.example.demo.model.Counter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountersRepository extends MongoRepository<Counter, String> {
    public Counter findById(String code);

}
