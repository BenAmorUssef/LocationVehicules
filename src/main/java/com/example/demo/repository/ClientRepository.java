package com.example.demo.repository;

import com.example.demo.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {
    public Client findByCodeClient(int code);

}
