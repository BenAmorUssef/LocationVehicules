package com.example.demo.repository;

import com.example.demo.model.Compte;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends MongoRepository<Compte, String> {
    public Compte findByCodeCompte(int code);

}
