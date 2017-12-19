package com.example.demo.repository;

import com.example.demo.model.Administrateur;
import com.example.demo.model.Compte;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends MongoRepository<Administrateur, String> {
    public Administrateur findByCodeAdmin(int code);
    public Administrateur findByCodeCompte(Compte c);
}
