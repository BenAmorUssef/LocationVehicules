package com.example.demo.repository;

import com.example.demo.model.Vehicule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculeRepository extends MongoRepository<Vehicule, String> {
    public Vehicule findByMatricule(String code);
    List<Vehicule> findAllByLocalite_CodeLocal(int code);
    List<Vehicule> findAllByTypeVehicule_CodeType(int code);
}
