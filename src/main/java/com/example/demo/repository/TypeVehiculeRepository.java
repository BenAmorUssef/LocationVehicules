package com.example.demo.repository;

import com.example.demo.model.Reservation;
import com.example.demo.model.TypeVehicule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeVehiculeRepository extends MongoRepository<TypeVehicule, String> {
    public TypeVehicule findByCodeType(int code);

}
